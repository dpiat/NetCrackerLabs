package com.nc.project.util.db;

import com.nc.project.model.client.Client;
import com.nc.project.model.contract.Contract;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository {
    void save(Contract contract) throws SQLException;
    List<Contract> getAllContracts() throws SQLException;
    Optional<Contract> getContractById(long id) throws SQLException;
    List<Client> getAllClients() throws SQLException;
}
