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
        this.array = newArray;
        this.size += 1;
    }

    public void add(Contract t) { // type mb is boolean
        Contract[] new_array =  new Contract[size+1];
        for (int i = 0; i < size; i++) {
            new_array[i] = this.array[i];
        }
        new_array[size] = t;
        this.array = new_array;
        this.size += 1;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
