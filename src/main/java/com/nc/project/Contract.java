package com.nc.project;
import java.util.Date;
import java.util.Objects;

public class Contract {
    private long id;
    private Date startContract;
    private Date endContract;
    private Client client;

    public Contract(long id, Date startContract, Date endContract, Client client) {
        this.id = id;
        this.startContract = startContract;
        this.endContract = endContract;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                Objects.equals(startContract, contract.startContract) &&
                Objects.equals(endContract, contract.endContract) &&
                Objects.equals(client, contract.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startContract, endContract, client);
    }
}
