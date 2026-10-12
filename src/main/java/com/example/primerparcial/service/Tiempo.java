package com.example.primerparcial.service;

import com.example.primerparcial.algotitmo.Sorter;

public class Tiempo {
    public static long measureTime(Sorter sorter, int[] array) {
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        return System.currentTimeMillis() - startTime;
    }
}
