package com.nc.project;

import java.util.Date;

public class DigitalTelevisionContract extends Contract {
    ChannelPackage channelPackage;

    public DigitalTelevisionContract(long id, Date startContract, Date endContract, Client client, ChannelPackage channelPackage) {
        super(id, startContract, endContract, client);
        this.channelPackage = channelPackage;
    }

    public ChannelPackage getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }
}
