package com.example.primerparcial.algotitmo;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Paralelo implements Sorter{
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        AtomicBoolean isSorted = new AtomicBoolean(false);

        while (!isSorted.get()) { //Fase par
            isSorted.set(true);
            IntStream.range(0, n / 2).parallel().forEach(i -> {
                int idx = i * 2;
                if (arr[idx] > arr[idx + 1]) {
                    swap(arr, idx, idx + 1);
                    isSorted.set(false);
                }
            });

            // Impar
            IntStream.range(0, (n - 1) / 2).parallel().forEach(i -> {
                int idx = i * 2 + 1;
                if (arr[idx] > arr[idx + 1]) {
                    swap(arr, idx, idx + 1);
                    isSorted.set(false);
                }
            });
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
