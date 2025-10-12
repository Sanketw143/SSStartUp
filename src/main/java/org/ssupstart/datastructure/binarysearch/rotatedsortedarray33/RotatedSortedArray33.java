package org.ssupstart.datastructure.binarysearch.rotatedsortedarray33;


/*There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.*/


public class RotatedSortedArray33 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = search(arr, 0);
        System.out.println(target);
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(target <= nums[end] && nums[mid] <= target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

}
