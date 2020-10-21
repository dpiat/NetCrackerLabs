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
            newArray[i] = this.array[i];
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
            newArray[i] = this.array[i];
        }
        for (int i = index + 1; i < size; i++) {
            newArray[i-1] = this.array[i];
        }
        array = newArray;
        size -= 1;
        return newArray[index];
    }

    public boolean remove(Contract t) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.array[i] == t) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Contract[] newArray = new Contract[size - 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = this.array[i];
            }
            for (int i = index + 1; i < size; i++) {
                newArray[i-1] = this.array[i];
            }
            array = newArray;
            size -= 1;
            return true;
        } else {
            return false;
        }
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
