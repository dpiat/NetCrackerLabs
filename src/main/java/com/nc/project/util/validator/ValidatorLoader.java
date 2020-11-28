package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

public class ValidatorLoader {
    public static void doValidation(Validator[] validators, Contract contract) {
        for (Validator validator : validators) {
            System.out.println(validator.validate(contract));
        }
    }
}
