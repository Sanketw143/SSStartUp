package org.ssupstart.datastructure.top150questionsleetcode.removeelement234.RemoveElement26DONE2;


               //  i       j
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//
//              [0,1,0,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5,
// with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the
// returned k (hence they are underscores).

public class RemoveElement26V3 {
    public static void main(String[] args) {
        int [] arr = {0,0,1,1,1,2,2,3,3,4};
        //compareAndSwap
        int result = removeDuplicateFromArrayV2(arr);
        System.out.println(result);
    }
    private static int removeDuplicateFromArrayV2(int[] arr) {
        int i = 0;
        int j = 1;
        while(j <= arr.length-1) {
            if(arr[i] == arr[j]) {
                j++;
            } else {
                int temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return i+1;
    }
    private static int removeDuplicateFromArray(int[] arr) {
        int i = 0;
        int j=1;

        while(j<arr.length) {
            if(arr[i] == arr[j]) {
                j++;
            } else {
                int temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return i+1;
    }
}
