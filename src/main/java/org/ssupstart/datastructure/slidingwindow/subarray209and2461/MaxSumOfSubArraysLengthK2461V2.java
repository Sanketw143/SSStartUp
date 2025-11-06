package org.ssupstart.datastructure.slidingwindow.subarray209and2461;

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

import java.util.HashSet;

public class MaxSumOfSubArraysLengthK2461V2 {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int maxSum = getMaxSumOfSubArray(arr, 3);
        System.out.println(maxSum);
    }

    private static int getMaxSumOfSubArray(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left =0;
        int right =0;
        int result = 0;
        int currSum =0;
        while (right < arr.length) {
            //he imp ahe set madhe element ashe paryant ani set chi size jr k evdhi zali ki
            // element remove karaych baghav lagal toparyant joparyanr varch don condition tutat nahit mhanun
            //if chya jagi while yenar
            while(set.contains(arr[right]) || set.size()==k) {
                currSum = currSum - arr[left];
                set.remove(arr[left]);
                left++;

            }
            // ek set ghetla tyat element add kela currsum kadhli ani set madhe
            // k element ale ki max sum baghaylot
            set.add(arr[right]);
            currSum += arr[right];
            if(set.size() == k) {
                result = Math.max(result,currSum);
            }
            right++;
        }
        return result;
    }
}
