package org.ssupstart.datastructure.top150questionsleetcode.rotatearray189DONE6;


import java.util.Arrays;

/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
*/
public class RotateArray189 {
    public static void main(String[] args) {
        //rotate array la 2 appraoch ahet
        //ek swap karat raha

        //second array reverse kara
        //k paryan che element reverse kara ani k nntr che reverse kara

        int[] arr = {1,2,3,4,5,6,7};
        int[] result = rotateArrayByK(arr,4);
        System.out.println(Arrays.toString(result));
    }

    private static int[] rotateArrayByK(int[] arr, int k) {
        reverseArray(arr, 0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        return arr;
    }

    public static void reverseArray(int[] arr, int startIndex, int endIndex) {
        while(startIndex<=endIndex) {
            int temp = arr[startIndex];
            arr[startIndex++] = arr[endIndex];
            arr[endIndex--] = temp;
            //startIndex++;
            //endIndex--;
        }
    }
}
