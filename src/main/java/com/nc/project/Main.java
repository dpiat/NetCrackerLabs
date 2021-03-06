package com.nc.project;

import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.Contract;
import com.nc.project.sorter.slow.BubbleSorter;
import com.nc.project.util.CSVReader;
import com.nc.project.util.injector.Injector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = new Injector();
        String csvFilePath = "src\\main\\resources\\contracts.csv";
        Repository<Contract> contractRepository = new Repository<>();
        CSVReader csvReader = new CSVReader();
        injector.inject(csvReader);
        csvReader.readCSV(csvFilePath, contractRepository);
        injector.inject(contractRepository);
        System.out.println(contractRepository.toString());
    }
}
