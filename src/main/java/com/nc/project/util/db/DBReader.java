package com.nc.project.util.db;

import com.nc.project.model.client.Client;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.Contract;
import com.nc.project.model.contract.DigitalTelevisionContract;
import com.nc.project.model.contract.InternetContract;
import com.nc.project.model.contract.MobileContract;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DBReader {
    void saveClient(Client client) throws SQLException;
    void saveContract(Contract contract) throws SQLException;
    Repository<Contract> getAllContracts() throws SQLException;
    List<Client> getAllClients() throws SQLException;
}
