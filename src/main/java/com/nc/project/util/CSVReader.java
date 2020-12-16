package com.nc.project.util;

import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.Contract;
import com.nc.project.model.contract.ContractFactory;
import com.nc.project.util.injector.AutoInjectable;
import com.nc.project.util.validator.validatorsImpl.BirthClientValidator;
import com.nc.project.util.validator.validatorsImpl.NumberContractValidator;
import com.nc.project.util.validator.Validator;
import com.nc.project.util.validator.ValidatorLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CSVReader {


    @AutoInjectable(parameter = Validator.class)
    private ArrayList<Validator> validators;
    /**
     * Reads from csv file
     *
     * @param csvFilePath - path of csv file
     * @param contractRepository - repository for storage of contracts
     */
    public void readCSV(String csvFilePath, Repository<Contract> contractRepository) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
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
                ValidatorLoader.doValidation(validators, contract);
                contractRepository.add(contract);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
