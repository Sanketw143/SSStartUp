package org.ssupstart.datastructure.top150questionsleetcode.removeelement234.removeelement27DONE3;


//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2,
//with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k
//(hence they are underscores).
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        //check not equal to if equal to then place on i;
        int result = removeDuplicateV2(arr, 3);
        System.out.println(result);
    }
    private static int removeDuplicateV2(int[] arr, int target) {
        int i=0;
        for(int ele : arr) {
            if(ele != target) {
                arr[i] = ele;
                i++;
            }
        }
        return i;
    }
    private static int removeDuplicate(int[] arr, int target) {
        int i=0;

        for(int j=0; j<arr.length; j++) {
            if(arr[j] != target) {
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }
}
