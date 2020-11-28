package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

public class NumberContractValidator implements Validator {
    @Override
    public ResultValidation validate(Contract contract) {
        long numberContract = contract.getNumberContract();

        if (numberContract % 1000 == 666) {
            return new ResultValidation("ORANGE RISK",
                    "Number of devil");
        }
        return new ResultValidation("OK");
    }
}
