package com.nc.project;

import java.util.Date;

public class MobileContract extends Contract {
    private long cntMin;
    private long cntMessages;

    public MobileContract(long id, Date startContract, Date endContract, Client client, long cntMin, long cntMessages) {
        super(id, startContract, endContract, client);
        this.cntMin = cntMin;
        this.cntMessages = cntMessages;
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
}

