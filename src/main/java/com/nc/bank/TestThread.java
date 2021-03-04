package com.nc.bank;

public class TestThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("TestThread: I'm doing something");
            System.out.println("TestThread: I've finished doing something, now i'm going to sleep, zzZzzZ");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
