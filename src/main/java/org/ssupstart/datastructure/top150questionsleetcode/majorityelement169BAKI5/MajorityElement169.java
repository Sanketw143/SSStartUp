package org.ssupstart.datastructure.top150questionsleetcode.majorityelement169BAKI5;


/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement169 {
    public static void main(String[] args) {
        //int[] arr = {2,2,1,1,1,2,2};
        int[] arr = {1,3,1,1,4,1,1,5,1,1,6,2,2};
        //int noUseResult = getMajorityElementBySort(arr); //nlogn
        int result = getMajorityElementByHashMap(arr); // n
        int resultTwo = getMajorityElementByAlgoV2(arr); //
        System.out.println(result + " " + resultTwo);
    }

    private static int getMajorityElementByAlgoV2(int[] arr) {
        return 0;
    }

    //Moore Voting Algorithm
    private static int getMajorityElementByAlgo(int[] arr) {
        int count = 0;
        int candidate = arr[0];

        for(int ele : arr) {
            if(ele == candidate) {
                count++;
            } else if(count!=0) {
                count--;
            }
            if(count == 0) {
                candidate = ele;
                count = 1;
            }
        }

        return candidate;
    }

    private static int getMajorityElementByHashMap(int[] arr) {
        HashMap<Integer,Integer> elementCountMap = new HashMap<>();
        for(int ele : arr) {
            elementCountMap.put(ele, elementCountMap.getOrDefault(ele,0) + 1);
            if(elementCountMap.get(ele) > arr.length/2)
                return ele;
        }
        return 0;
    }

    private static int getMajorityElementBySort(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
