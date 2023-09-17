package org.pegasus.algorithm.class04;

import org.pegasus.algorithm.class01.TestCaseUtils;

/**
 * 本题测试链接 : https://leetcode.com/problems/reverse-pairs/
 */
public class BiggerThanRightTwice {
    public static int reversePairComparator(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isABiggerThanBTwice(arr[i], arr[j])) {
                    result++;
                }
            }
        }
        return result++;
    }

    public static boolean isABiggerThanBTwice(int a, int b) {
        return (long) a > (long) b * 2;
    }

    public static boolean isABiggerThanBTwiceError(int a, int b) {
        int half = a >> 1;
        return (half > b) || (half == b && a % 2 == 1);
    }

    public static int reversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int result = 0;
        int pr = m + 1;

        for (int i = l; i <= m; i++) {
            while (pr <= r && isABiggerThanBTwice(arr[i], arr[pr])) {
                pr++;
            }
            result += pr - m - 1;
        }

        int[] help = new int[r - l + 1];
        int i = 0, p1 = l, p2 = m + 1;
        while (p1 <= m && p2 <= r) {
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
        return result;
    }

    public static void main(String[] args) {

        int maxSize = 1000, maxValue = Integer.MAX_VALUE;
        int times = 100000;
        boolean testFlag = true;
        for (int i = 0; i < times; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = TestCaseUtils.copyArray(arr);
            if (reversePairComparator(arr) != reversePair(arr1)) {
                testFlag = false;
                System.out.println("test failed!!!");
                TestCaseUtils.printArray(arr);
                TestCaseUtils.printArray(arr1);
                break;
            }
        }
        if (testFlag) {
            System.out.println("test success!!!");
        }
    }
}
