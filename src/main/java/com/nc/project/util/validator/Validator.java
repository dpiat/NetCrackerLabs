package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

public interface Validator {
    /**
     * Gets contract and do validation
     * @param contract to be validated
     * @return result of Validation
     */
    public ResultValidation validate(Contract contract);
}
