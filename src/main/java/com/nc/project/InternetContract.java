package com.nc.project;

import java.util.Date;
import java.util.Objects;

public class InternetContract extends Contract {
    private long maxSpeed;

    public InternetContract(long id, Date startContract, Date endContract, Client client, long maxSpeed) {
        super(id, startContract, endContract, client);
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
}
