package com.nc.project.model.client;

import java.util.Date;
import java.util.Objects;

public class Client {
    private long id;
    private String FIO;
    private Date birthday;
    private String gender;
    private long passport;

    public Client(long id, String FIO, Date birthday, String gender, long passport) {
        this.id = id;
        this.FIO = FIO;
        this.birthday = birthday;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPassport() {
        return passport;
    }

    public void setPassport(long passport) {
        this.passport = passport;
    }

    public int getAge() {
        long ageInMillis = new Date().getTime() - birthday.getTime();

        Date age = new Date(ageInMillis);

        return age.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                passport == client.passport &&
                Objects.equals(FIO, client.FIO) &&
                Objects.equals(birthday, client.birthday) &&
                Objects.equals(gender, client.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FIO, birthday, gender, passport);
    }
}
