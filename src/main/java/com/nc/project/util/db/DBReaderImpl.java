package com.nc.project.util.db;

import com.nc.project.model.client.Client;
import com.nc.project.model.client.ClientFactory;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.*;
import com.nc.project.util.validator.ValidatorLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DBReaderImpl implements DBReader {

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
    public void saveClient(Client client) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String insertTableSQL = "INSERT INTO clients(\n" +
                "\tid, passport, fio, gender, birthday)\n" +
                "\tVALUES " +
                "(" +
                client.getId() + "," +
                client.getPassport() + ",'" +
                client.getFIO() + "', '"+
                client.getGender() + "', '" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(client.getBirthday()) + "')";
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
    public void saveContract(Contract contract) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String insertTableSQL;
        String contractType = contract.getClass().getName().replace("com.nc.project.model.contract.", "");
        switch (contractType) {
            case "InternetContract":
                insertTableSQL = "INSERT INTO contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"startContract\", "
                        + "        \"endContract\", "
                        + "        \"descriptor\", "
                        + "        \"maxSpeed\", "
                        + "        \"clientId\") " + "VALUES"
                        + "(" + contract.getId() + ", " +
                        contract.getNumberContract() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getStartContract()) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getEndContract()) + "', '" +
                        contractType + "', " +
                        ((InternetContract)contract).getMaxSpeed() + ", " +
                        contract.getClient().getId() + ")";
                break;
            case "DigitalTelevisionContract":
                insertTableSQL = "INSERT INTO contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"startContract\", "
                        + "        \"endContract\", "
                        + "        \"channelPackage\", "
                        + "        \"descriptor\", "
                        + "        \"clientId\") " + "VALUES"
                        + "(" + contract.getId() + ", " +
                        contract.getNumberContract() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getStartContract()) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getEndContract()) + "', '" +
                        ((DigitalTelevisionContract) contract).getChannelPackage() + "', '" +
                        contractType + "', " +
                        contract.getClient().getId() + ")";
                break;
            case "MobileContract":
                insertTableSQL = "INSERT INTO contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"startContract\", "
                        + "        \"endContract\", "
                        + "        \"descriptor\", "
                        + "        \"cntMin\", "
                        + "        \"cntMessages\", "
                        + "        \"cntGb\", "
                        + "        \"clientId\") " + "VALUES"
                        + "(" + contract.getId() + ", " +
                        contract.getNumberContract() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getStartContract()) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(contract.getEndContract()) + "', '" +
                        contractType + "', " +
                        ((MobileContract) contract).getCntMin() + ", " +
                        ((MobileContract) contract).getCntMessages() + ", " +
                        ((MobileContract) contract).getCntGb() + ", " +
                        contract.getClient().getId() + ")";
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
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
    public Repository<Contract>  getAllContracts() throws SQLException {
        Repository<Contract> contractRepository = new Repository<>();
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from contracts c1 left join clients c on c1.\"clientId\" = c.id";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                long contractId = rs.getLong("contractId");
                long numberContract = rs.getLong("numberContract");
                Date startContract = rs.getDate("startContract");
                Date endContract = rs.getDate("endContract");
                String channelPackage = rs.getString("channelPackage");
                String descriptor = rs.getString("descriptor");
                long maxSpeed = rs.getLong("maxSpeed");
                long cntMin = rs.getLong("cntMin");
                long cntMessages = rs.getLong("cntMessages");
                long cntGb = rs.getLong("cntGb");

                long id = rs.getLong("id");
                String FIO = rs.getString("fio");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                long passport = rs.getLong("passport");
                try {
                    Client client = clientFactory.getClient(id, FIO, birthday, gender, passport);
                    Contract contract = contractFactory.getContract(id, numberContract, startContract, client, endContract, channelPackage, descriptor, maxSpeed, cntMin, cntMessages, cntGb);
                    System.out.println(contract.toString());
                    contractRepository.add(contract);
                }
                catch (Exception e) {
                    System.out.println("Reading error");
                }

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
        return contractRepository;
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
