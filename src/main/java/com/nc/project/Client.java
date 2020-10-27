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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getPassport() {
        return passport;
    }

    public void setPassport(long passport) {
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
