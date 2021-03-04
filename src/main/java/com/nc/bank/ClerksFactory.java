package com.nc.bank;

import java.util.ArrayList;
import java.util.List;

public class ClerksFactory {

    private ClerksFactory() {}

    public static List<Clerk> initializeClerks(int N) {
        List<Clerk> clerks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Clerk clerk = new Clerk();
            clerk.start();
            clerks.add(clerk);
        }
        return clerks;
    }
}
