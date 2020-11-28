package com.nc.project.util.validator;

import com.nc.project.model.contract.Contract;

import java.util.Date;

public class BirthClientValidator implements Validator {
    @Override
    public ResultValidation validate(Contract contract) {
        Date birthday = contract.getClient().getBirthday();
        Date currDate = new Date();
        if (currDate.getYear()-birthday.getYear() >= 200) {
            return new ResultValidation("RED RISK",
                    "We've found a vampire");
        }
        return new ResultValidation("OK");
    }
}
