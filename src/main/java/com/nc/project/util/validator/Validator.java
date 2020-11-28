package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

public interface Validator {
    public ResultValidation validate(Contract contract);
}
