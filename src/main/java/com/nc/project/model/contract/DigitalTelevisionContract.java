package com.nc.project.model.contract;

import com.nc.project.model.client.Client;

import java.util.Date;
import java.util.Objects;

public class DigitalTelevisionContract extends Contract {
    String channelPackage;

    public DigitalTelevisionContract(long id, long numberContract, Date startContract, Date endContract, Client client, String channelPackage) {
        super(id, numberContract, startContract, endContract, client);
        this.channelPackage = channelPackage;
    }


    public String getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(String channelPackage) {
        this.channelPackage = channelPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DigitalTelevisionContract that = (DigitalTelevisionContract) o;
        return channelPackage == that.channelPackage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), channelPackage);
    }

    @Override
    public String toString() {
        return "DigitalTelevisionContract{" +
                "channelPackage='" + channelPackage + '\'' +
                ", id=" + id +
                ", numberContract=" + numberContract +
                ", startContract=" + startContract +
                ", endContract=" + endContract +
                ", client=" + client +
                '}';
    }
}
