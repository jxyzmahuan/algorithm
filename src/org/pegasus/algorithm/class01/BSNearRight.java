package org.pegasus.algorithm.class01;

import java.util.Arrays;

public class BSNearRight {
    // 在arr上，找满足<=value的最右位置
    public static int nearestIndex(int[] arr, int value) {
        int l=0,r=arr.length-1;
        int index = -1;
        while (l<=r){
            int mid = l+((r-l)>>1);
            if(arr[mid]<=value){
                index=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return index;
    }
    public static int test(int[] arr,int value){
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = TestCaseUtils.generateRandomArray(maxSize, maxValue);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            Arrays.sort(arr);
            if (nearestIndex(arr, value) != test(arr, value)) {
                TestCaseUtils.printArray(arr);
                System.out.println(value);
                succeed = false;
            }
        }
        System.out.println(succeed ? "test success" : "test failed");
    }
}
