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
        Contract[] new_array =  new Contract[size+1];
        for (int i = 0; i < index; i++)
        {
            new_array[i] = array[i];
        }
        new_array[index] = t;
        for (int i = index; i < size; i++)
        {
            new_array[i + 1] = array[i];
        }
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
