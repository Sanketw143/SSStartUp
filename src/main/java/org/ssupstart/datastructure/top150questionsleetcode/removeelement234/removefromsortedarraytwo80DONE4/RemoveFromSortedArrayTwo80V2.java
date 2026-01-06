package org.ssupstart.datastructure.top150questionsleetcode.removeelement234.removefromsortedarraytwo80DONE4;

//                       j i
//Input: nums = [1,1,2,2,3,2]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5,
// with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k
// (hence they are underscores).
public class RemoveFromSortedArrayTwo80V2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int result = removeDuplicateAtMostTwoAllowedV2(arr);
        System.out.println(result);
    }

    private static int removeDuplicateAtMostTwoAllowedV2(int[] arr) {
        int i=2;
        int j=2;
        for(i=2; i<arr.length; i++) {
            if(arr[i] != arr[j-2]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }

    private static int removeDuplicateAtMostTwoAllowed(int[] arr) {
        int j = 2;
        for(int i=2; i<arr.length; i++) {
            if(arr[i] != arr[j-2]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
