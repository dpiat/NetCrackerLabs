package com.nc.project;

import com.nc.project.model.client.Client;
import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.ContractFactory;
import com.nc.project.model.contract.Contract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "src\\main\\resources\\contracts.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
            Repository<Contract> contractRepository = new Repository<>();
            ClientFactory clientFactory = new ClientFactory();
            ContractFactory contractFactory = new ContractFactory();
            String line = bufferedReader.readLine(); // skip first row
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                String[] startContract = values[2].split("-");
                String[] endContract = values[3].split("-");
                String[] birthday = values[6].split("-");
                Contract contract = contractFactory.getContract(
                        Long.parseLong(values[0]),
                        Long.parseLong(values[1]),
                        new Date(
                                Integer.parseInt(startContract[2]),
                                Integer.parseInt(startContract[1]),
                                Integer.parseInt(startContract[0])
                        ),
                        new Date(
                                Integer.parseInt(endContract[2]),
                                Integer.parseInt(endContract[1]),
                                Integer.parseInt(endContract[0])
                        ),
                        clientFactory.getClient(
                                Long.parseLong(values[4]),
                                values[5],
                                new Date(
                                        Integer.parseInt(birthday[2]),
                                        Integer.parseInt(birthday[1]),
                                        Integer.parseInt(birthday[0])
                                ),
                                values[7],
                                Long.parseLong(values[8])
                        ),
                        values[9]
                );
                contractRepository.add(contract);
            }
            System.out.println(contractRepository.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
