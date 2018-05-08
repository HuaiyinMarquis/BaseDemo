package com.exampleDemo.ThreadTest.domo;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by ChenMP on 2017/11/7.
 */
public class RechargeThread implements Runnable {

    private PersonAccount personAccount;
    private Random random;

    public RechargeThread(PersonAccount personAccount, Random random) {
        this.personAccount = personAccount;
        this.random = random;
    }

    @Override
    public void run() {
        for (int i=0; i<20000; i++) {
            personAccount.recharge(new BigDecimal(random.nextInt(200)), i);

            if (i == 100) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
            }

        }
    }
}
