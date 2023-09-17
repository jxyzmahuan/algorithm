package org.pegasus.algorithm.class04;

import org.pegasus.algorithm.class01.TestCaseUtils;

/**
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和返回
    // 所有merge时，产生的小和，累加
    // 左 排序   merge
    // 右 排序  merge
    // merge
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid)  + process(arr, mid + 1, r) + merge(arr, l, mid, r);

    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int sum = 0, i = 0, p1 = l, p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            sum += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return sum;
    }

    public static int smallSumComparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int maxSize = 1000, maxValue = 1000;
        int times = 10000;
        boolean testFlag = true;
        for (int i = 0; i < times; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = TestCaseUtils.copyArray(arr);
            int[] arr2 = TestCaseUtils.copyArray(arr);
            int sum1 = smallSum(arr1);
            int sum2 = smallSumComparator(arr2);
            if (sum1 != sum2) {
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
