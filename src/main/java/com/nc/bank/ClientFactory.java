package com.nc.bank;

import java.util.ArrayList;
import java.util.List;

public class ClientFactory extends Thread{
    private int clientsPerMinute;
    private List<Client> clients;

    public ClientFactory(int clientsPerMinute) {
        this.clientsPerMinute = clientsPerMinute;
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("ClientFactory: I'm creating new clients");
            for (int i = 0; i < clientsPerMinute; i++) {
                clients.add(new Client());
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