package org.ssupstart.datastructure.slidingwindow.subarray209and2461;

import java.util.HashSet;
import java.util.Set;



public class Pactice2 {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int maxSum = getSumArray(arr,3);
        System.out.println(maxSum);
    }

    private static int getSumArray(int[] arr, int k) {
        int left = 0;
        int right= 0;
        Set<Integer> set = new HashSet<>();
        int currSum =0; int maxSum=0;

        while(right<arr.length) {
            while(set.size()==3||set.contains(arr[right])) {
                currSum = currSum-arr[left];
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]); //1 5 4
            currSum = currSum+arr[right]; //1//6//10
            if(set.size() == k) {
                maxSum = Math.max(currSum,maxSum);
            }
            right++;
        }
        return maxSum;


        // 1 5 4 3 7 6 4 3 7
    }
}
