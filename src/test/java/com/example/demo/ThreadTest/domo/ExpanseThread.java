package com.example.demo.ThreadTest.domo;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by ChenMP on 2017/11/7.
 */
public class ExpanseThread implements Runnable {

    private PersonAccount personAccount;
    private Random random;

    public ExpanseThread(PersonAccount personAccount, Random random) {
        this.personAccount = personAccount;
        this.random = random;
    }

    @Override
    public void run() {
        for (int i=0; i<20000; i++) {
            personAccount.expense(new BigDecimal(random.nextInt(100)), i);

        }
    }
}
