package com.nc.project;

import com.nc.project.model.client.Client;
import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.ContractFactory;
import com.nc.project.model.contract.Contract;
import com.nc.project.util.CSVReader;

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
        Repository<Contract> contractRepository = new Repository<>();
        CSVReader.readCSV(csvFilePath, contractRepository);
        System.out.println(contractRepository.toString());
    }
}
