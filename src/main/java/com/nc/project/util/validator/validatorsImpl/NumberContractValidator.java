package com.nc.project.util.validator.validatorsImpl;

import com.nc.project.model.contract.Contract;
import com.nc.project.util.validator.ResultValidation;
import com.nc.project.util.validator.Validator;

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
