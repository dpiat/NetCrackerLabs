package com.nc.project;

import java.util.Comparator;

public interface ISorter<T> {
    public void sort(Contract[] contracts , Comparator<? super Contract> comparator);
}
