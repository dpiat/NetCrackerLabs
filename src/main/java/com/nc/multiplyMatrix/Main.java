package com.nc.multiplyMatrix;

import java.util.Random;

public class Main {

    private static final int THREADS_COUNT = 16;

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getRandomNumber(1, 10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int rows1 = 100, cols1 = 100, rows2 = 100, cols2 = 100;
        int[][] A = generateMatrix(rows1, cols1);
        int[][] B = generateMatrix(rows2, cols2);
        int[][] C1 = new int[rows1][cols2];

        long startTime = System.currentTimeMillis();
        ThreadsController.multiply(A, B, C1, THREADS_COUNT);
        System.out.println((System.currentTimeMillis() - startTime) + " ms");
    }
}
