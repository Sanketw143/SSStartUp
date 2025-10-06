package org.ssupstart.datastructure.twopointeralgo.leetcodes.boatstosave881;


//ToDo
//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
// where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
//
//
//
//        Example 1:
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)

import java.util.Arrays;

public class BoatsToSavePeople881V3 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        int minBoats = getMinimumBoats(arr, 3);
        System.out.println(minBoats);
    }

    private static int getMinimumBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int result = 0;
        int start =0;
        int end = arr.length-1;

        while(start<=end) {
            result++;
            if(arr[start] + arr[end] <= limit) {
                start++;
            }
            end--;
        }
        return result;
    }
}
