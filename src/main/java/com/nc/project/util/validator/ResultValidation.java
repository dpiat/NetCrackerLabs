package com.nc.project.util.validator;

public class ResultValidation {
    String status;
    String description;

    public ResultValidation(String status) {
        this.status = status;
    }

    public ResultValidation(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ResultValidation{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
