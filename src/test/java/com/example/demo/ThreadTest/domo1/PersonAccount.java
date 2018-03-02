package com.example.demo.ThreadTest.domo1;

import java.math.BigDecimal;

/**
 * Created by ChenMP on 2017/11/7.
 */
public class PersonAccount {
    private volatile String name;
    private BigDecimal account;

    public PersonAccount(String name, BigDecimal account) {
        this.name = name;
        this.account = account;
    }

    public synchronized void recharge(BigDecimal value, int i) {
        account = account.add(value);
        System.out.println("第"+i+"次充值成功，充值金额为："+value+"，总金额为："+account);
        this.notify();
        if (i==50) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void expense(BigDecimal value, int i) {
        while (account.compareTo(value) == -1) {
            System.out.println("第"+i+"次消费阻塞，消费金额为："+value+"，总金额为："+account);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        account = account.subtract(value);
        System.out.println("第"+i+"次消费成功，消费金额为："+value+"，总金额为："+account);
    }
}
