package com.nc.bank;

public class Cashbox {

    private int cash;

    public Cashbox(int cash) {
        this.cash = cash;
    }

    public int withdraw(int query) {
        if (cash - query >= 0) {
            cash -= query;
            return query;
        } else {
            return -1;
        }
    }

    public void topUp(int money) {
        cash += money;
    }

    public int getCash() {
        return cash;
    }
}
