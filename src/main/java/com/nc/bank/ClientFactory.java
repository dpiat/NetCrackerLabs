package com.nc.bank;

import java.util.List;

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
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("ClientFactory: I'm creating new clients");
            for (int i = 0; i < clientsPerMinute; i++) {
                Client client = new Client();
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