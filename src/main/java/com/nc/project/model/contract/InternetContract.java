package com.nc.project.model.contract;

import com.nc.project.model.client.Client;

import java.util.Date;
import java.util.Objects;

public class InternetContract extends Contract {
    private long maxSpeed;

    public InternetContract(long id, long numberContract, Date startContract, Date endContract, Client client, long maxSpeed) {
        super(id, numberContract, startContract, endContract, client);
        this.maxSpeed = maxSpeed;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetContract that = (InternetContract) o;
        return maxSpeed == that.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed);
    }

    @Override
    public String toString() {
        return "InternetContract{" +
                "maxSpeed=" + maxSpeed +
                ", id=" + id +
                ", numberContract=" + numberContract +
                ", startContract=" + startContract +
                ", endContract=" + endContract +
                ", client=" + client +
                '}';
    }
}
