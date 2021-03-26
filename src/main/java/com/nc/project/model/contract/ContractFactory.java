package com.nc.project.model.contract;

import com.nc.project.model.client.Client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContractFactory {
    private Set<Contract> contracts = new HashSet<>();

    public Contract getContract(long id, long numberContract, Date startContract, Date endContract, Client client, java.lang.String addInfo) {
        for (Contract contract : contracts) {
            if (contract.getId() == id) {
                return contract;
            }
        }
        String[] valuesAddInfo = addInfo.split(";");
        switch (valuesAddInfo[0]) {
            case "MobileContract":
                return new MobileContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        Long.parseLong(valuesAddInfo[1]),
                        Long.parseLong(valuesAddInfo[2]),
                        Long.parseLong(valuesAddInfo[3])
                );
            case "DigitalTelevisionContract":
                return new DigitalTelevisionContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        valuesAddInfo[1]
                );
            case "InternetContract":
                return new InternetContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        Long.parseLong(valuesAddInfo[1])
                );
            default:
                throw new IllegalStateException("Unexpected value: " + valuesAddInfo[0]);
        }
    }

    public Contract getContract( long id, long numberContract, Date startContract, Client client, Date endContract, String channelPackage, String descriptor, long maxSpeed, long cntMin, long cntMessages, long cntGb) {
        for (Contract contract : contracts) {
            if (contract.getId() == id) {
                return contract;
            }
        }
        switch (descriptor) {
            case "MobileContract":
                return new MobileContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        cntMin,
                        cntMessages,
                        cntGb
                );
            case "DigitalTelevisionContract":
                return new DigitalTelevisionContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        channelPackage
                );
            case "InternetContract":
                return new InternetContract(
                        id,
                        numberContract,
                        startContract,
                        endContract,
                        client,
                        maxSpeed
                );
            default:
                throw new IllegalStateException("Unexpected value: " + descriptor);
        }
    }
}
