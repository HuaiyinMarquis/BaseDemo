package com.exampleDemo;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

enum LocationTax {
    CA("California",0.0975,new String[]{"food"}), NY("New York",0.08875,new String[]{"food","clothing"});

    String cityName;
    double salesTaxRate;
    String[] exempt;

    LocationTax(String cityName,double salesTaxRate,String[] exempt) {
        this.cityName = cityName;
        this.salesTaxRate = salesTaxRate;
        this.exempt = exempt;
    }
}


public class ShoppingReceiptProcesser {
    Map<String, String> productType; //use to store product's name and product's type

    @Before
    public void init() { //init the base data
        productType = new HashMap<>();
        productType.put("book","reeading");
        productType.put("potato chips","food");
        productType.put("pencil","tool");
        productType.put("shirt","clothing");

    }

    void printReceipt(List<ProductInfo> productInfos, LocationTax location) {
        double subtotal = 0;
        double tax = 0;
        double total = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("item\t\t\t\tprice\t\t\t\tqty");
        for (ProductInfo info : productInfos) {
            System.out.print(info.getProductName() + "\t\t\t\t" + info.getProductPrice()
                    + "\t\t\t\t" + info.getQuantity() + "\n");

            subtotal += (info.getProductPrice()*info.getQuantity());
            boolean match = Arrays.stream(location.exempt)
                    .anyMatch(str -> str.equals(productType.get(info.getProductName())));
            if (!match) { // not exempt
                tax += (info.getProductPrice()*info.getQuantity()*location.salesTaxRate);
            }
        }

        tax = ((int)(tax/0.05))*0.05 + ((tax%0.05)>0?0.05:0);
        total = subtotal + tax;

        System.out.println("subtotal: \t\t\t\t\t\t\t\t$"
                + new BigDecimal(subtotal).setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("tax: \t\t\t\t\t\t\t\t$" + df.format(tax));
        System.out.println("total: \t\t\t\t\t\t\t\t$"
                + new BigDecimal(total).setScale(2,BigDecimal.ROUND_HALF_DOWN));
    }

    @Test
    public void testDemo() {
        List<ProductInfo> list = new ArrayList<>();
        ProductInfo info1 = new ProductInfo("book",17.99 ,1);
        ProductInfo info2 = new ProductInfo("pencil",2.99 ,3);
        list.add(info1);
        list.add(info2);
        printReceipt(list,LocationTax.NY);
    }

}



class ProductInfo{
    String productName;
    double productPrice;
    int quantity;

    public ProductInfo(String productName, double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

