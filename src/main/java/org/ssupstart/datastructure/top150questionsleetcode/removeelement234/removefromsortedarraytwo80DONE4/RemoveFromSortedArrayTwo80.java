package org.ssupstart.datastructure.top150questionsleetcode.removeelement234.removefromsortedarraytwo80DONE4;


//Unique element can be at most twice

// i   j
//[1,1,1,2,2,3]
//     i   j
//[1,1,2,2,2,3]

//[1,1,1,2,3,3]

//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5,
// with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k
// (hence they are underscores).
public class RemoveFromSortedArrayTwo80 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        //i ani j donihi 2 varun chalu karayche ani matching nasl tr put karun takaych
        int result = removeDuplicateAtMostTwoIsFine(arr);
        System.out.println(result);
    }

//     j ij
//[1,1,1,2,2,3]
//       ij
//[1,1,2,2,2,3]

//[1,1,1,2,3,3]
    private static int removeDuplicateAtMostTwoIsFine(int[] arr) {
        int j=2;
        for(int i=2; i<arr.length; i++) {
            if(arr[i] != arr[j-2]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
