package com.nc.project.model.contract;

import com.nc.project.model.client.Client;

import java.util.Date;
import java.util.Objects;

public class DigitalTelevisionContract extends Contract {
    ChannelPackage channelPackage;

    public DigitalTelevisionContract(long id, long numberConract, Date startContract, Date endContract, Client client, ChannelPackage channelPackage) {
        super(id, numberConract, startContract, endContract, client);
        this.channelPackage = channelPackage;
    }

    public ChannelPackage getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(ChannelPackage channelPackage) {
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
}
