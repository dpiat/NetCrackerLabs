package com.nc.project.model.contract;

import com.nc.project.model.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name="contract")
@XmlSeeAlso({Client.class})
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Contract {
    protected long id;
    protected long numberContract;
    protected Date startContract;
    protected Date endContract;
    @XmlElement(name="client")
    protected Client client;

    public Contract(long id, long numberContract, Date startContract, Date endContract, Client client) {
        this.id = id;
        this.numberContract = numberContract;
        this.startContract = startContract;
        this.endContract = endContract;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(long numberContract) {
        this.numberContract = numberContract;
    }

    public Date getStartContract() {
        return startContract;
    }

    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                numberContract == contract.numberContract &&
                Objects.equals(startContract, contract.startContract) &&
                Objects.equals(endContract, contract.endContract) &&
                Objects.equals(client, contract.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberContract, startContract, endContract, client);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", numberContract=" + numberContract +
                ", startContract=" + startContract +
                ", endContract=" + endContract +
                ", client=" + client +
                '}';
    }
}
