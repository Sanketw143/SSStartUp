package org.ssupstart.datastructure.binarysearch.binarysearch704;


//Given an array of integers nums which is sorted in ascending order, and an integer target,
//write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int result = binarySearch(arr, 9);
        System.out.println(result);
    }


    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while(left<=right) {
            int mid = (right+left)/2;
            if(arr[mid] < target) {
                left = mid+1;
            } else if(arr[mid] > target) {
                right = mid-1;
            } else if(arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
