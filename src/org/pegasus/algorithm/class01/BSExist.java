package org.pegasus.algorithm.class01;

import java.util.Arrays;

public class BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int l = 0, r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return sortedArr[l] == num;
    }

    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 5000000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                System.out.println(test(arr, value));
                System.out.println(exist(arr, value));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
