package org.ssupstart.datastructure.arraysleetcodes.intersectionofarray349;


//Given two integer arrays nums1 and nums2, return an array of their intersection.
//Each element in the result must be unique and you may return the result in any order.
//
//Example 1:
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.


import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrays349 {
    public static void main(String[] args) {
        int[] arr1 = {2,9,4,9,8,4};
        int[] arr2 = {4,9,5,2};
        int[] result = getIntersectionOfTwoArrays(arr1,arr2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getIntersectionOfTwoArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> elementsFirst = new HashSet<>();
        HashSet<Integer> finalArray = new HashSet<>();

        for (int i=0; i<arr2.length; i++) {
            elementsFirst.add(arr1[i]);
        }

        for(int k=0; k<arr2.length; k++) {
            if(elementsFirst.contains(arr2[k])) {
                finalArray.add(arr2[k]);
            }
        }
        return finalArray.stream().mapToInt(Integer :: intValue).toArray();
    }
}
