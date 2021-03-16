package com.nc.bank;

import java.util.List;
import java.util.Random;

public class ClientFactory extends Thread{
    private static int clientsPerMinute;
    private static List<Clerk> clerks = null;

    public ClientFactory(int clientsPerMinute, List<Clerk> clerks) {
        ClientFactory.clientsPerMinute = clientsPerMinute;
        ClientFactory.clerks = clerks;
    }

    public void placeIntoBestQueue(Client client) {
        Clerk best = clerks.get(0);
        for (Clerk clerk: clerks) {
            if (clerk.getQueue().size() < best.getQueue().size()) {
                best = clerk;
            }
        }
        best.getQueue().add(client);
        synchronized (best) {
            best.notify();
        }
    }


    public static Operation getRandomOperation() {
        Random random = new Random();
        return Operation.values()[random.nextInt(Operation.values().length)];
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("ClientFactory: I'm creating new clients");
            for (int i = 0; i < clientsPerMinute; i++) {
                Client client = new Client(getRandomOperation(), getRandomNumber(100, 1000));
                //Client client = new Client(Operation.WITHDRAW, getRandomNumber(100, 1000));
                placeIntoBestQueue(client);
            }
            System.out.println("ClientFactory: I've finished creating clients, now i'm going to sleep, zzZzzZ");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}