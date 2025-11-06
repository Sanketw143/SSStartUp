package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.removeduplicates26.baki;

//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
// The remaining elements of nums are not important as well as the size of nums.
//Return k.

//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveDuplicatesFromSortedArray26V2 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int distinctElementsCount = removeDuplicatesFromSortedArray(arr);
        System.out.println(distinctElementsCount);
    }

    private static int removeDuplicatesFromSortedArray(int[] arr) {
        int start = 0;
        int end = 1;

        while (end <= arr.length-1) {
            if(arr[start] == arr[end]) {
                end++;
            } else {
                swapNumbersV2(arr, start, end);
                start++;
                end++;
            }
        }
        return start+1;
    }

    private static void swapNumbersV2(int[] arr, int startPointer, int nextPointer) {
        int temp = arr[startPointer+1];
        arr[startPointer+1] = arr[nextPointer];
        arr[nextPointer] = temp;
    }

}
