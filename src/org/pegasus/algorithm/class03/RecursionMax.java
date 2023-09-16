package org.pegasus.algorithm.class03;

import org.pegasus.algorithm.class01.TestCaseUtils;

import java.util.Arrays;

public class RecursionMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        int[] temp = TestCaseUtils.generateRandomArray(maxSize, maxValue);
        System.out.println(getMax(temp));
    }
}
