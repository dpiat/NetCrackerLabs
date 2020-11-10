package com.nc.project.sorter;

import com.nc.project.model.contract.Contract;
import com.nc.project.repository.ISorter;

import java.util.Comparator;

public class BubbleSorter<T> implements ISorter<T> {

    @Override
    public void sort(Contract[] contracts, Comparator<? super Contract> comparator) {
        int n = contracts.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (comparator.compare(contracts[j], contracts[j+1]) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    Contract temp = contracts[j];
                    contracts[j] = contracts[j+1];
                    contracts[j+1] = temp;
                }
    }
}
