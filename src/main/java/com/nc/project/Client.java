package com.nc.project;

import java.util.Date;
import java.util.Objects;

public class Client {
    private long id;
    private String FIO;
    private Date birthday;
    private long passport;

    public Client(long id, String FIO, Date birthday, long passport) {
        this.id = id;
        this.FIO = FIO;
        this.birthday = birthday;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                passport == client.passport &&
                Objects.equals(FIO, client.FIO) &&
                Objects.equals(birthday, client.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FIO, birthday, passport);
    }
}
