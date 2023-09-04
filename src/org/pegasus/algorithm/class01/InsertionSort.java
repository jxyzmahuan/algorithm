package org.pegasus.algorithm.class01;

public class InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
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
            insertionSort(arr1);
            TestCaseUtils.comparator(arr2);
            if (!TestCaseUtils.isEqual(arr1, arr2)) {
                testFlag = false;
                System.out.println("test failed!");
                TestCaseUtils.printArray(arr);
                TestCaseUtils.printArray(arr1);
                TestCaseUtils.printArray(arr2);
                break;
            }
        }
        if (testFlag) {
            System.out.println("test success!");
        }
    }
}
