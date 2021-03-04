package com.nc.bank;

public class Main {

    private static final int N = 10;
    private static final int SERVICE_TIME = 1000;
    private static final int CLIENTS_PER_MINUTE = 5;
    private static final int INIT_CASH = 10000;

    public static void main(String[] args) {
        Cashbox cashbox = new Cashbox(INIT_CASH);

    }
}
