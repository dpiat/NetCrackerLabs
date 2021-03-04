package com.nc.multiplyMatrix;

public class Multiplier extends Thread {
    private int[][] A;
    private int[][] B;
    private int[][] C;
    private int row;
    private int col;

    public Multiplier(int[][] A, int[][] B, int[][] C, int row, int col) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
    }

    // Поток считает ячейку матрицы
    @Override
    public void run() {
        //System.out.println("Поток начал работу:::"+ Thread.currentThread().getName());
        C[row][col] = 0;
        for (int i = 0; i < A[0].length; i++) {
           C[row][col] += A[row][i] * B[i][col];
        }
        //System.out.println("Поток завершил работу:::"+ Thread.currentThread().getName());
    }

}
