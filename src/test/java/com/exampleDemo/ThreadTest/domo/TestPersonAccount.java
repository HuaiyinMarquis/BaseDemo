package com.exampleDemo.ThreadTest.domo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenMP on 2017/11/7.
 */
public class TestPersonAccount {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        PersonAccount personAccount = new PersonAccount("user",new BigDecimal("0"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new ExpanseThread(personAccount,random));
        executorService.execute(new RechargeThread(personAccount,random));

//        Thread expensedThread = new Thread(new ExpanseThread(personAccount,random));
//        Thread rechargeThread = new Thread(new RechargeThread(personAccount,random));
//
//        rechargeThread.start();
//        rechargeThread.join();
//
//        expensedThread.start();


    }
}
