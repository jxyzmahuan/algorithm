package org.pegasus.algorithm.class02;

import org.pegasus.algorithm.class01.TestCaseUtils;

public class Swap {
    //xor
    public static void swap(int[] arr, int i, int j) {
        // arr[0] = arr[0] ^ arr[0];
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int maxSize=100,minValue=100;
        int[] arr= TestCaseUtils.generateRandomArray(maxSize,minValue);

    }
}
