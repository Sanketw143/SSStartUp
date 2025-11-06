package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.twosum1and167.DONE;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//
//
//
//Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:

import java.util.HashMap;
import java.util.Objects;

//Input: nums = [3,3], target = 6
//Output: [0,1]
public class TwoSum1And167 {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int [] result = getTwoSum(arr,6);
        int [] twoPointerResult = getTwoSumByTwoPointer(arr, 6);
        if(Objects.requireNonNull(twoPointerResult).length ==2)
            System.out.println(twoPointerResult[0] + "  " + twoPointerResult[1]);
//        if(Objects.requireNonNull(result).length ==2)
//            System.out.println(result[0] + "  " + result[1]);
    }

    private static int[] getTwoSumByTwoPointer(int[] arr, int target) {
        int startPointer = 0;
        int endPointer = arr.length-1;
        int[] result = new int[2];

        while (startPointer<endPointer) {
            int sum = arr[startPointer] + arr[endPointer];
            if(sum == target) {
                result[0] = startPointer+1;
                result[1] = endPointer+1;
                return result;
            } else if(sum > target) {
                endPointer--;
            } else {
                startPointer++;
            }
        }
        return null;
    }

    public static int[] getTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> numAndIndexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (numAndIndexMap.containsKey(target - arr[i])) {
                result[0] = numAndIndexMap.get(target-arr[i]);
                result[1] = i;
                return result;
            }
            numAndIndexMap.put(arr[i], i);
        }
        return result;
    }
}
