package com.example.primerparcial.ar;

import java.util.Random;

public class ArrayGen {
    private ArrayGen() {
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }
}
