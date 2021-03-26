package com.nc.project;

import com.nc.project.exception.InjectException;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.Contract;
import com.nc.project.util.CSVReader;
import com.nc.project.util.db.DBReaderImpl;
import com.nc.project.util.injector.Injector;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InjectException {
        Injector injector = new Injector();
        String csvFilePath = "src\\main\\resources\\contracts.csv";
        Repository<Contract> contractRepository = new Repository<>();
        CSVReader csvReader = new CSVReader();
        injector.inject(csvReader);
        csvReader.readCSV(csvFilePath, contractRepository);
        injector.inject(contractRepository);
        //System.out.println(contractRepository.toString());

        DBReaderImpl dbReader = new DBReaderImpl();

       /* for (int i = 0; i < contractRepository.size(); i++) {
            Optional<Contract> contract = contractRepository.get(i);
            if (contract.isPresent()) {
                try {
                    dbReader.saveContract(contract.get());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }*/

        try {
            dbReader.getAllClients();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            dbReader.getAllContracts();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
