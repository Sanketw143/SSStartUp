package org.ssupstart.datastructure.slidingwindow.subarray209and2461;



//Given an array of positive integers nums and a positive integer target,
//return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

public class MaxSubArraySum209 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int result = subArrayByTarget(arr, 7);
        System.out.println(result);
    }

    private static int subArrayByTarget(int[] arr, int target) {
        int result = Integer.MAX_VALUE;

        int left=0, right=0;
        int currSum = 0;


        while(right<arr.length) {
            currSum = currSum + arr[right];
            while(currSum >= target) {
                if((right-left) + 1 < result) {
                    result = right - left + 1;
                }
                currSum = currSum - arr[left];
                left++;
            }
            right++;
        }
        return result;
    }
}
