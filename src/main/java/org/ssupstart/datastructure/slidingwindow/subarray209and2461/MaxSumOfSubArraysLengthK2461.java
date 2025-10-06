package org.ssupstart.datastructure.slidingwindow.subarray209and2461;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

//You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
//
//The length of the subarray is k, and
//All the elements of the subarray are distinct.
//Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Input: nums = [1,5,4,2,9,9,9], k = 3
//Output: 15
//Explanation: The subarrays of nums with length 3 are:
//        - [1,5,4] which meets the requirements and has a sum of 10.
//        - [5,4,2] which meets the requirements and has a sum of 11.
//        - [4,2,9] which meets the requirements and has a sum of 15.
//        - [2,9,9] which does not meet the requirements because the element 9 is repeated.
//        - [9,9,9] which does not meet the requirements because the element 9 is repeated.
//We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

@Slf4j
public class MaxSumOfSubArraysLengthK2461 {
    public static void main(String[] args) {
        //set 5,4   sum = need to calculate
        int[] inputArr = {9,9,9};
        //                  lr
        int resultSum = getSumOfSubArrayOfSizeK(inputArr, 3);
        System.out.println("max sum is " + resultSum);
    }


    private static int getSumOfSubArrayOfSizeK(int[] arr, int k) {
        int left=0;
        int right=0;
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int currSum = 0;

        while (right < arr.length) {
            while (set.contains(arr[right]) || set.size()==k) {
                currSum = currSum - arr[left];
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            currSum = currSum + arr[right];
            if(set.size() == k) {
                maxSum = Math.max(currSum,maxSum);  // 11
            }
            right++;
        }
        return maxSum;
    }


}



