package org.ssupstart.datastructure.binarysearch.search2dmatrix74;



/*You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.*/


public class Search2Dmatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        boolean result = searchMatrix(matrix, 31);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix) {
            int left = 0;
            int right = arr.length-1;
            if(target == arr[left] || target == arr[right])
                return true;
            else if(target > arr[left] && target < arr[right] && binarySearch(arr, target) != -1) {
                return true;
            }
        }
        return false;
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
