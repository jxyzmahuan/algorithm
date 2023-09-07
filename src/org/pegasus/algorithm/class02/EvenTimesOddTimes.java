package org.pegasus.algorithm.class02;

import org.pegasus.algorithm.class01.TestCaseUtils;

public class EvenTimesOddTimes {
    //arr中，只有一种数，出现奇数次
    public static int findOddTimesNum1(int[] arr) {
        int xor = 0;
        for (int v : arr) {
            xor ^= v;
        }
        return xor;
    }

    //arr中，2种数，出现奇数次
    public static int[] findOddTimesNum2(int[] arr) {
        //xor= a^b
        int xor = 0;
        for (int v : arr) {
            xor ^= v;
        }
        // a 和 b是两种数
        // xor != 0
        // xor最右侧的1，提取出来
        // xor :     00110010110111000
        // rightOne :00000000000001000
        int right = xor & (-xor);

        int a = 0;
        for (int v : arr) {
            if ((v & right) == 0) {
                a ^= v;
            }
        }
        int[] result = new int[2];
        result[0] = a;
        result[1] = a ^ xor;
        return result;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        System.out.println(findOddTimesNum1(arr1));


        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2, 3, 5};
        TestCaseUtils.printArray(findOddTimesNum2(arr2));
    }
}
