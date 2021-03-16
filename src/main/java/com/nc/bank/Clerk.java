package com.nc.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Clerk extends Thread {
    private static int serviceTime;
    private static Cashbox cashbox;
    private LinkedList<Client> queue = new LinkedList<>();

    @Override
    public void run() {
        while (true) {
            while (!queue.isEmpty()) { // работаем с клиентами
                Client client = queue.pollFirst();
                System.out.println("Clerk - " + Thread.currentThread().getId() +
                        " is maintaining a client. Operation: " + client.getOperation().toString() + ", money: " + client.getMoney());
                switch (client.getOperation()) {
                    case ADD:
                        cashbox.add(client.getMoney());
                        break;
                    case WITHDRAW:
                        if (cashbox.getCash() - client.getMoney() >= 0) {
                            cashbox.withdraw(client.getMoney());
                        } else {
                            System.out.println("Clerk - " + Thread.currentThread().getId() + " can't maintain a client");
                        }
                }
                try {
                    Thread.sleep(serviceTime);
                    System.out.println("Clerk - " + Thread.currentThread().getId() + " has finished maintaining a client");
                } catch (InterruptedException e) {
                    e.printStackTrace(System.out);
                }
            }


            System.out.println("Clerk - " + Thread.currentThread().getId() + " is free");
            synchronized(this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Client> getQueue() {
        return queue;
    }

    public static void setServiceTime(int serviceTime) {
        Clerk.serviceTime = serviceTime;
    }

    public static void setCashbox(Cashbox cashbox) {
        Clerk.cashbox = cashbox;
    }
}