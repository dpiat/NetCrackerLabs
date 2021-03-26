package com.nc.project.util.db;

import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.contract.Contract;
import com.nc.project.model.contract.ContractFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class DBReader {

    public static void read() throws IOException, SQLException {

/*
        ClientFactory clientFactory = new ClientFactory();
        ContractFactory contractFactory = new ContractFactory();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            while (resultSet.next()) {
                System.out.println();
                String[] startContract = resultSet.getString(3).split("-");
                String[] endContract = resultSet.getString(4).split("-");
                String[] birthday = resultSet.getString(7).split("-");
                Contract contract = contractFactory.getContract(
                        resultSet.getLong(1),
                        resultSet.getLong(2),
                        new java.util.Date(
                                Integer.parseInt(startContract[3]),
                                Integer.parseInt(startContract[2]),
                                Integer.parseInt(startContract[1])
                        ),
                        new java.util.Date(
                                Integer.parseInt(endContract[3]),
                                Integer.parseInt(endContract[2]),
                                Integer.parseInt(endContract[1])
                        ),
                        clientFactory.getClient(
                                resultSet.getLong(5),
                                resultSet.getString(6),
                                new Date(
                                        Integer.parseInt(birthday[3]),
                                        Integer.parseInt(birthday[2]),
                                        Integer.parseInt(birthday[1])
                                ),
                                resultSet.getString(8),
                                resultSet.getLong(9)
                        ),
                        resultSet.getString(10)
                );
            }
            statement.close();
            connection.close();
        }*/


    }
}
