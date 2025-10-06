package org.ssupstart.datastructure.twopointeralgo.leetcodes.removeduplicates26;


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


// 1,1,1,2,2               -- > 1,2,_,_,_;
// i     j
// 1 2 1 1 2
//   i     j

// 0,0,1,2,2               -- > 0,1,2
// i   j
// 0,1,2,2,0
//     i   j
public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
    public static int removeDuplicates(int[] nums) {
        int startPointer = 0;
        int endPointer = 1;
        while(endPointer <= nums.length-1) {
            if(nums[startPointer] == nums[endPointer]) {
                endPointer++;
            } else {
                swapNumbers(nums, startPointer, endPointer);
                startPointer++;
                endPointer++;
            }
        }
        return startPointer+1;
    }

    private static void swapNumbers(int[] nums, int startPointer, int endPointer) {
        int temp =0;
        temp = nums[startPointer +1];
        nums[startPointer +1] = nums[endPointer];
        nums[endPointer] = temp;
    }
}
