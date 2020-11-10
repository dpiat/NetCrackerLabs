package com.nc.project.repository;

import com.nc.project.model.contract.Contract;

import java.util.Comparator;
import java.util.function.Predicate;

public interface IRepository<T> {
    public void sortBy(Comparator<? super Contract> comparator);
    public IRepository<T> searchBy(Predicate<T> predicate);
}
