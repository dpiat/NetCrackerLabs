package com.nc.bank;

public class Cashbox extends Thread {

    private int cash;

    public Cashbox(int cash) {
        this.cash = cash;
    }

    synchronized public int withdraw(int query) {
        System.out.println("Cashbox before operation: " + cash);
        if (cash - query >= 0) {
            cash -= query;
            System.out.println("Cashbox after operation: " + cash);
            return query;
        } else {
            return -1;
        }
    }

    synchronized public void add(int money) {
        System.out.println("Cashbox before operation: " + cash);
        cash += money;
        System.out.println("Cashbox after operation: " + cash);
    }

    public int getCash() {
        return cash;
    }
}
