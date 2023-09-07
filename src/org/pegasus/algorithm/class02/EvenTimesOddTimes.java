package org.pegasus.algorithm.class02;

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
}
