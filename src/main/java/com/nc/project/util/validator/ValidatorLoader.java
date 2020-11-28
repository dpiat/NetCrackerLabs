package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

public class ValidatorLoader {
    /**
     * Gets validators and contract then do validation by these validators
     * @param validators - validators
     * @param contract to be validated
     */
    public static void doValidation(Validator[] validators, Contract contract) {
        for (Validator validator : validators) {
            System.out.println(validator.validate(contract));
        }
    }
}
