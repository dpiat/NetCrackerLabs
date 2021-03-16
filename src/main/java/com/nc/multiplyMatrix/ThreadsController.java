package com.nc.multiplyMatrix;

import java.util.ArrayList;
import java.util.List;

public class ThreadsController {
    public static void multiply(int[][] A, int[][] B, int[][] C, int cntThreads) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                Multiplier multiplier = new Multiplier(A, B, C, i, j);
                Thread thread = new Thread(multiplier);
                thread.start();
                threads.add(thread);
                if (threads.size() % cntThreads == 0) {
                    waitForThreads(threads);
                }
            }
        }
        waitForThreads(threads);
    }

    // Метод, который ждет когда все потоки в списке закончат свою работу. Минусы: если освободится место под поток,
    // то мы его не добавляем в группу потоков, а ждем когда все потоки в группе закончат свою работу.
    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
