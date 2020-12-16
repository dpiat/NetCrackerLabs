package com.nc.project.model.container;

import com.nc.project.model.contract.Contract;
import com.nc.project.repository.IRepository;
import com.nc.project.repository.ISorter;
import com.nc.project.sorter.slow.BubbleSorter;
import com.nc.project.util.injector.AutoInjectable;

import java.util.*;
import java.util.function.Predicate;

/**
 * This is a class container for Contract
 *
 * @author  Dmitrii Piataikin
 * @version 1.0
 */
public class Repository<T> implements IRepository<T> {
    @AutoInjectable(parameter = Contract.class)
    ISorter<Contract> sorter = new BubbleSorter<>();
    private int size ;
    private Contract[] array;

    /**
     * Constructs an empty repository with an initial size of 0.
     */
    public Repository() {
        this.size = 0;
    }

    /**
     * Constructs an repository with an initial size of {@code size}.
     *
     * @param size initial size of repository
     */
    public Repository(int size) {
        this.size = size;
    }

    /**
     * Appends the specified element to the end of this repository.
     *
     * @param element element to be appended to this repository
     */
    public void add(Contract element) {
        Contract[] newArray =  new Contract[size+1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        newArray[size] = element;
        array = newArray;
        size += 1;
    }

    /**
     * Returns the element at the specified position in this repository.
     *
     * @param id of contract to return
     * @return the element at the specified position in this repository
     */
    public Optional<Contract> get(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getId() == id) {
                return Optional.of(array[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * Removes the specified element with id if it is present in this repository.
     *
     * @param id the index of the element to be removed
     * @return the element that was removed from the repository
     */
    public Optional<Contract> remove(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Contract[] newArray = new Contract[size - 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            for (int i = index + 1; i < size; i++) {
                newArray[i - 1] = array[i];
            }
            array = newArray;
            size -= 1;
            return Optional.of(newArray[index]);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Removes the first occurrence of the specified element from this repository,
     * if it is present.
     *
     * @param t element to be removed from this repository, if present
     * @return {@code true} if this repository contained the specified element
     */
    public boolean remove(Contract t) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Contract[] newArray = new Contract[size - 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            for (int i = index + 1; i < size; i++) {
                newArray[i-1] = array[i];
            }
            array = newArray;
            size -= 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of elements in this repository.
     *
     * @return the number of elements in this repository
     */
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this repository. The repository will
     * be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        array = null;
        size = 0;
    }

    /**
     * Returns the result of calling {@code toString}.
     *
     * @return the result of calling
     * @see Object#toString
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(array[i].toString());
            if (i + 1 != size) {
                sb.append(",\n").append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Sorts contract with given comparator
     *
     * @param comparator
     */
    @Override
    public void sortBy(Comparator<? super Contract> comparator) {
        sorter.sort(array, comparator);
    }

    /**
     * Returns repository with elems that satisfy the predicate
     * 
     * @param predicate
     * @return
     */
    @Override
    public Repository<T> searchBy(Predicate<T> predicate) {
        Repository<T> repository = new Repository<>();
        for (Contract contract : array) {
            if (predicate.test((T) contract)) {
                repository.add(contract);
            }
        }
        return repository;
    }
}
