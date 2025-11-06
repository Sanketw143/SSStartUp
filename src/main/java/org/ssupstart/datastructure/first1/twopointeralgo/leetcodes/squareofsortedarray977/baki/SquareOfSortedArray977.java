package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.squareofsortedarray977.baki;


import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//Example 1:
//
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//        After sorting, it becomes [0,1,9,16,100].
//Example 2:
//
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
public class SquareOfSortedArray977 {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        int[] result = sortedSquares(arr);
        System.out.println(Arrays.toString(Arrays.stream(result).sorted().toArray()));
        System.out.println(Arrays.toString(sortedSquaresTwoPointer(arr)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        return Arrays.stream(result).sorted().toArray();
    }

    public static int[] sortedSquaresTwoPointer(int[] nums) {
        int l = 0, len = nums.length, r = len - 1;
        int idx = len - 1;
        int[] temp = new int[len];
        while(idx>=0){
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                temp[idx] = nums[l] * nums[l];
                l++;
            } else {
                temp[idx] = nums[r] * nums[r];
                r--;
            }
            idx--;
        }
        return temp;
    }
}
