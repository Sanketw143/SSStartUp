package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.boatstosave881.DONE;

import java.util.Arrays;

public class BoatsToSaveV4 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        int numberOfBoats = minimumNUmberOfBoats(arr, 3);
        System.out.println(numberOfBoats);
    }

    private static int minimumNUmberOfBoats(int[] arr, int limit) {
        Arrays.sort(arr); // 1,2,2,3
        int leftPerson =0;
        int rightPerson = arr.length-1;
        int numberOfBoats = 0;
                 //0          //3 -> 2
        while(leftPerson <= rightPerson) {
            numberOfBoats++;  //1

                   //1                  3              3
            if(arr[leftPerson] + arr[rightPerson] <= limit) {
                leftPerson++;
            }
            rightPerson--;
        }
        return numberOfBoats;
    }
}
