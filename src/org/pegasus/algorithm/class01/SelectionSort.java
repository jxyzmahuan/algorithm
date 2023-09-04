package org.pegasus.algorithm.class01;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 1000, maxValue = 1000;
        int times = 10000;
        boolean testFlag = true;
        for (int i = 0; i < times; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = TestCaseUtils.copyArray(arr);
            int[] arr2 = TestCaseUtils.copyArray(arr);
            selectionSort(arr1);
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
