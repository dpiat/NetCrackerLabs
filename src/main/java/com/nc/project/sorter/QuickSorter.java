package com.nc.project.sorter;


import com.nc.project.model.contract.Contract;
import com.nc.project.repository.ISorter;

import java.util.Comparator;

public class QuickSorter<T> implements ISorter<T> {
    @Override
    public void sort (Contract[] contracts, Comparator<? super Contract> comparator ) {
        quickSort( contracts, comparator, 0, contracts.length-1 );
    }

    int partition(Contract contracts[],  Comparator<? super Contract> comparator, int low, int high)
    {
        Contract pivot = contracts[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (comparator.compare(contracts[j],pivot) > 0)
            {
                i++;

                // swap arr[j+1] and arr[j]
                Contract temp = contracts[j];
                contracts[j] = contracts[j+1];
                contracts[j+1] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Contract temp = contracts[i+1];
        contracts[i+1] = contracts[high];
        contracts[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void quickSort(Contract contracts[], Comparator<? super Contract> comparator, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(contracts, comparator, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(contracts, comparator, low, pi-1);
            quickSort(contracts, comparator, pi+1, high);
        }
    }
}
