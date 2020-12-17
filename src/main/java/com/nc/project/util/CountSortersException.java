package com.nc.project.util;

public class CountSortersException extends Exception{
    public CountSortersException() {
        super("Found nothing or more than one sorter!");
    }
}
