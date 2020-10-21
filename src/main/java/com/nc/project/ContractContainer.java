package com.nc.project;

public class ContractContainer {
    private int size ;
    private Contract[] array;

    public ContractContainer() {
        this.size = 0;
    }
    public ContractContainer(int size) {
        this.size = size;
    }

    public void add(int index, Contract t){
        rangeCheckForAdd(index);
        Contract[] newArray =  new Contract[size+1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = t;
        for (int i = index; i < size; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
        size += 1;
    }

    public void add(Contract t) { // type mb is boolean
        Contract[] newArray =  new Contract[size+1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        newArray[size] = t;
        array = newArray;
        size += 1;
    }

    public Contract get(int index) {
        checkIndex(index);
        return array[index];
    }

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

    public Contract set(int index, Contract element) {
        checkIndex(index);
        Contract oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        array = null;
        size = 0;
    }

    public boolean contains(Contract t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

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

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
