package com.nc.project;
import java.util.Date;
import java.util.Objects;

public class Contract {
    private long id;
    private long numberConract;
    private Date startContract;
    private Date endContract;
    private Client client;

    public Contract(long id, long numberConract, Date startContract, Date endContract, Client client) {
        this.id = id;
        this.numberConract = numberConract;
        this.startContract = startContract;
        this.endContract = endContract;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumberConract() {
        return numberConract;
    }

    public void setNumberConract(long numberConract) {
        this.numberConract = numberConract;
    }

    public Date getStartContract() {
        return startContract;
    }

    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                numberConract == contract.numberConract &&
                Objects.equals(startContract, contract.startContract) &&
                Objects.equals(endContract, contract.endContract) &&
                Objects.equals(client, contract.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberConract, startContract, endContract, client);
    }
}
