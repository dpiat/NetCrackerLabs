package com.nc.bank;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int N = 2;
    private static final int SERVICE_TIME = 1000;
    private static final int CLIENTS_PER_MINUTE = 5;
    private static final int INIT_CASH = 10000;

    public static void main(String[] args) {
        Cashbox cashbox = new Cashbox(INIT_CASH);
        List<Clerk> clerks = ClerksFactory.initializeClerks(N);
        ClientFactory clientFactory = new ClientFactory(CLIENTS_PER_MINUTE, clerks);
        clientFactory.start();
    }
}
