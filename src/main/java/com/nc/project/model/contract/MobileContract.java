package com.nc.project.model.contract;

import com.nc.project.model.client.Client;

import java.util.Date;
import java.util.Objects;

public class MobileContract extends Contract {
    private long cntMin;
    private long cntMessages;
    private long cntGb;

    public MobileContract(long id, long numberContract, Date startContract, Date endContract, Client client, long cntMin, long cntMessages, long cntGb) {
        super(id, numberContract, startContract, endContract, client);
        this.cntMin = cntMin;
        this.cntMessages = cntMessages;
        this.cntGb = cntGb;
    }

    public long getCntMin() {
        return cntMin;
    }

    public void setCntMin(long cntMin) {
        this.cntMin = cntMin;
    }

    public long getCntMessages() {
        return cntMessages;
    }

    public void setCntMessages(long cntMessages) {
        this.cntMessages = cntMessages;
    }

    public long getCntGb() {
        return cntGb;
    }

    public void setCntGb(long cntGb) {
        this.cntGb = cntGb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileContract that = (MobileContract) o;
        return cntMin == that.cntMin &&
                cntMessages == that.cntMessages &&
                cntGb == that.cntGb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cntMin, cntMessages, cntGb);
    }
}

