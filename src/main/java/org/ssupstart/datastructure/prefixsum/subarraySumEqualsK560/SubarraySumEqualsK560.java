package org.ssupstart.datastructure.prefixsum.subarraySumEqualsK560;


//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3};
        int totalSubArrays = sumEqualToK(arr, 3);
    }

    private static int sumEqualToK(int[] arr, int k) {
        int subArrayCount =0;
        int sum = 0;
        Map<Integer,Integer> sumAndSubArrayCountMap = new HashMap<>();
        sumAndSubArrayCountMap.put(0,1); //0,1 && 1,1
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(sumAndSubArrayCountMap.containsKey(sum-k)) {
                subArrayCount += sumAndSubArrayCountMap.get(sum-k);
            }
            sumAndSubArrayCountMap.put(sum, sumAndSubArrayCountMap.getOrDefault(sum,0)+1);
        }
        return subArrayCount;
    }
}
