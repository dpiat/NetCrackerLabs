package com.nc.project.model.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ClientFactory {
    Set<Client> clients = new HashSet<>();

    public Client getClient(long id, String FIO, Date birthday, String gender, long passport) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        Client client = new Client(id, FIO, birthday, gender, passport);
        clients.add(client);
        return client;
    }
}
