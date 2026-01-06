package org.ssupstart.datastructure.top150questionsleetcode.rotatearray189DONE6;

import java.util.Arrays;

public class RotateArrayV2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] result = rotateArrayByKV2(arr,4);
        System.out.println(Arrays.toString(result));
    }

    private static int[] rotateArrayByKV2(int[] arr, int k) {
        reverseV2(arr, 0, arr.length-1);
        reverseV2(arr, 0, k-1);
        reverseV2(arr, k, arr.length-1);
        return arr;
    }

    private static void reverseV2(int[] arr, int start, int end) {
        while(start<=end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
