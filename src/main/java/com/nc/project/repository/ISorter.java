package com.nc.project.repository;

import com.nc.project.model.contract.Contract;

import java.util.Comparator;

public interface ISorter<T> {
    public void sort(Contract[] contracts , Comparator<? super Contract> comparator);
}
