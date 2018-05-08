package com.example.demo.SqlTest;

import java.sql.*;

/**
 *
 *
 * Created by ChenMP on 2018/3/28.
 */
public class InsertDB {
    static String URL="jdbc:mysql://192.168.182.132:3306/jieshitong?useUnicode=true&amp;characterEncoding=utf-8";
    static String USER="root";
    static String PASSWORD="123456";
    public static void main(String[] args) {
        Connection conn= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
            Statement st=conn.createStatement();
            StringBuilder insertProductInfo = new StringBuilder();
            insertProductInfo.append("INSERT INTO product_info VALUES ");
            StringBuilder insertProductStatus = new StringBuilder();
            insertProductStatus.append("INSERT INTO product_status VALUES ");
            for (int i=36; i<70; i++) {
                insertProductInfo.append("('code").append(i).append("','productName").append(i).append("',3.3,2.2,'").append(i%10).append("','").append(i%5).append("'),");
                for (int n=0; n<10000; n++) {
                    String time;
                    if (n%5 == 0)
                        time = "2018-01";
                    else if (n%5 == 1)
                        time = "2018-02";
                    else if (n%5 == 2)
                        time = "2018-03";
                    else if (n%5 == 3)
                        time = "2018-04";
                    else
                        time = "2019-05";
                    insertProductStatus.append("('").append(time).append("','").append(n % 50).append("','name").append(n % 50).append("','code")
                            .append(i).append("','registCode:").append(time).append("',5,'carname").append(n % 30).append("','carcode").append(n % 30)
                            .append("',").append(n % 2).append(",").append(i%2).append(",'',''),");
                }
            }
            insertProductInfo.append(",");
            insertProductStatus.append(",");
            boolean execute1 = st.execute(insertProductInfo.toString().replace(",,",""));
            boolean execute2 = st.execute(insertProductStatus.toString().replace(",,", ""));

            conn.commit();
            st.close();
            conn.close();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
