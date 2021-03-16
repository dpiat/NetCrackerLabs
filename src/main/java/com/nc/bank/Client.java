package com.nc.bank;

public class Client {
    private Operation operation;
    private int money;

    public Client(Operation operation, int money) {
        this.operation = operation;
        this.money = money;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getMoney() {
        return money;
    }
}
