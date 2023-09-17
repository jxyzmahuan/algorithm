package org.pegasus.algorithm.class04;

import org.pegasus.algorithm.class01.TestCaseUtils;

public class MergeSort {
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1, N = arr.length;
        while (step < N) {
            int L = 0;
            while (L < N) {
                if (step >= N - L) {
                    break;
                }
                int M = L + step - 1;
                int R = Math.min(M + step, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (step > N / 2) {
                break;
            }
            step <<= 1;
        }
    }

    public static void main(String[] args) {
        int maxSize = 1000, maxValue = 1000;
        int times = 10000;
        boolean testFlag = true;
        for (int i = 0; i < times; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = TestCaseUtils.copyArray(arr);
            int[] arr2 = TestCaseUtils.copyArray(arr);
            mergeSort2(arr1);
            TestCaseUtils.comparator(arr2);
            if (!TestCaseUtils.isEqual(arr1, arr2)) {
                testFlag = false;
                TestCaseUtils.printArray(arr);
                TestCaseUtils.printArray(arr1);
                TestCaseUtils.printArray(arr2);
                System.out.println("MergeSort Error!!!");
                break;
            }
        }
        if (testFlag) {
            System.out.println("MergeSort Success!!!");
        }
    }
}
