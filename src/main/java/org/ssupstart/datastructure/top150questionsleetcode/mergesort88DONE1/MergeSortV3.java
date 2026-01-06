package org.ssupstart.datastructure.top150questionsleetcode.mergesort88DONE1;


//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

import java.util.Arrays;

public class MergeSortV3 {
    public static void main(String[] args) {
        int[] num1 = {4,5,6,0,0,0};
        int[] num2 = {1,2,3};
        // magun suru karav lagal
        mergeTwoSortedArraysV4(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));
    }

    private static void mergeTwoSortedArraysV4(int[] num1, int m, int[] num2, int n) {
        int i = m-1;
        int j = n-1;
        int k = num1.length-1;

        while(i>=0 && j>=0) {
            if(num1[i] > num2[j]) {
                num1[k] = num1[i];
                i--;
            } else {
                num1[k] = num2[j];
                j--;
            }
            k--;
        }

        while(j>=0) {
            num1[k] = num2[j];
            k--;
            j--;
        }
    }

    private static void mergeTwoSortedArrays(int[] num1, int m, int[] num2, int n) {
        int i = m-1;
        int j = n-1;
        int k = num1.length-1;

        while(i>=0 && j>=0) {
            if(num1[i] > num2[j]) {
                num1[k] = num1[i];
                i--;
            } else {
                num1[k] = num2[j];
                j--;
            }
            k--;
        }

        while(j>=0) {
            num1[k] = num2[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(num1));
    }
}
