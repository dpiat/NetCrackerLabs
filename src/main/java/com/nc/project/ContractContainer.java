package com.nc.project;

import java.util.*;

/**
 * Resizable-array implements all optional list operations, and permits all elements.
 * In addition to implementing, this class provides methods to manipulate the size of
 * the array that is mused internally to store the list.
 *
 * <p>The {@code size}, {@code isEmpty}, {@code get}, {@code set},operations run in
 * constant time.  The {@code add} operation runs in <i>amortized constant time</i>,
 * that is, adding n elements requires O(n) time.  All of the other operations
 * run in linear time (roughly speaking).
 *
 * @author  Dmitrii Piataikin
 * @version 1.0
 */
public class ContractContainer {
    private int size ;
    private Contract[] array;

    /**
     * Constructs an empty list with an initial size of 0.
     */
    public ContractContainer() {
        this.size = 0;
    }

    /**
     * Constructs an list with an initial size of {@code size}.
     *
     * @param size initial size of list
     */
    public ContractContainer(int size) {
        this.size = size;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, Contract element) {
        rangeCheckForAdd(index);
        Contract[] newArray =  new Contract[size+1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index; i < size; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
        size += 1;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
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
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Contract get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Removes the specified element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Contract remove(int index) {
        checkIndex(index);
        Contract[] newArray = new Contract[size - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index + 1; i < size; i++) {
            newArray[i-1] = array[i];
        }
        array = newArray;
        size -= 1;
        return newArray[index];
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.
     *
     * @param t element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    public boolean remove(Contract t) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == t) {
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
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Contract set(int index, Contract element) {
        checkIndex(index);
        Contract oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list. The list will
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
     * Returns {@code true} if this list contains the specified element.
     *
     * @param t element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(Contract t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                return true;
            }
        }
        return false;
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
                sb.append(',').append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * A version of rangeCheck used by add.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Checks if the {@code index} is within the bounds of the range from
     * {@code 0} (inclusive) to {@code length} (exclusive).
     *
     * @param index the index
     * @throws IndexOutOfBoundsException if the {@code index} is out of bounds
     */
    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
