package org.ssupstart.datastructure.top150questionsleetcode.hindex11;

import java.util.Arrays;

public class Hindex274 {
    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        //0,1,3,6,5
        int result = hindex(arr);
        int resultTwo = hindexOptimised(arr);
        System.out.println(result);
    }

    private static int hindexOptimised(int[] arr) {
        int [] freq = new int[arr.length+1];

        for(int i=0;i<arr.length; i++) {
            int val = arr[i];
            if(val >= arr.length) {
                freq[arr.length]++;
            } else {
                freq[val]++;
            }
        }
        int count = 0;
        for(int i=arr.length; i>0; i--) {
            count += freq[i];
            if(count>=i) {
                return i;
            }
        }
        return 0;
    }

    private static int hindex(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= arr.length-i) {
                return arr.length-i;
            }
        }
        return 0;
    }
}
