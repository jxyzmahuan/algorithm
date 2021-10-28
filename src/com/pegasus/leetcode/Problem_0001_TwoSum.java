package com.pegasus.leetcode;

import java.util.HashMap;

public class Problem_0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> resultMap=new  HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(resultMap.containsKey(target-nums[i])){
                result[0]=resultMap.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            resultMap.put(nums[i],i);
        }
        return result;
    }
}
