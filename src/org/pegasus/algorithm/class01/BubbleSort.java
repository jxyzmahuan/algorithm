package org.pegasus.algorithm.class01;

public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
            bubbleSort(arr1);
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
