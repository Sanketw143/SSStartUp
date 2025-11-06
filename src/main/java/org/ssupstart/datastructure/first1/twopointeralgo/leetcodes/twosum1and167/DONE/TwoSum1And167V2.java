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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
public class TwoSum1And167V2 {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int[] result = twoSum(arr, 6);
        int[] result1 = twoSumUsingTwoPointerForSortedArrayOnly(arr,6);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }

    private static int[] twoSumUsingTwoPointerForSortedArrayOnly(int[] arr, int target) {
        int start =0;
        int end = arr.length-1;
        int [] result = new int[2];

        while (start<end) {
            int sum = arr[start] + arr[end];
            if(sum == target) {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> valueAndIndexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i=0; i<arr.length; i++) {
            if(valueAndIndexMap.containsKey(target - arr[i])) {
                result[0] = i;
                result[1] = valueAndIndexMap.get(target - arr[i]);
                return result;
            }
            valueAndIndexMap.put(arr[i], i);
        }
        return result;
    }
}
