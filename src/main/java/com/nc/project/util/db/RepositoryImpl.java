package com.nc.project.util.db;

import com.nc.project.model.client.Client;
import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.contract.Contract;
import com.nc.project.model.contract.ContractFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

public class RepositoryImpl implements Repository {

    private static ClientFactory clientFactory = new ClientFactory();
    private static ContractFactory contractFactory = new ContractFactory();


    private Connection getDBConnection() {
        FileInputStream dbp = null;
        try {
            dbp = new FileInputStream("src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties props = new Properties();
        try {
            props.load(dbp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("datasource.url");
        String driver = props.getProperty("datasource.driver");
        String username = props.getProperty("datasource.username");
        String password = props.getProperty("datasource.password");

        Connection dbConnection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(url, username, password);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }


    @Override
    public void save(Contract contract) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String insertTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
                + "(1,'mkyong','system', " + "to_date('"
                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.execute(insertTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    @Override
    public List<Contract> getAllContracts() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT USER_ID, USERNAME from DBUSER";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }

    @Override
    public Optional<Contract> getContractById(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        List<Client> clients = new ArrayList<>();
        String selectTableSQL = "SELECT c.* from clients c";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                long id = rs.getLong("id");
                String FIO = rs.getString("fio");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                long passport = rs.getLong("passport");
                Client client = clientFactory.getClient(id, FIO, birthday, gender, passport);
                System.out.println(client.toString());
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }

        return clients;
    }

    private String getCurrentTimeStamp() {
        Date today = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(today.getTime());
    }
}
