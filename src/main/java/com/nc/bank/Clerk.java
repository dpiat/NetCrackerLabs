package com.nc.bank;

import java.util.ArrayList;
import java.util.List;

public class Clerk extends Thread {
    private List<Client> queue = new ArrayList<>();

    public List<Client> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Clerk: " + Thread.currentThread().getName() + " " +queue.size());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }

    }
}
