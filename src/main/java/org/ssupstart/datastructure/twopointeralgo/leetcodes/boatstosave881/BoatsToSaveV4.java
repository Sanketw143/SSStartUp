package org.ssupstart.datastructure.twopointeralgo.leetcodes.boatstosave881;

import java.util.Arrays;

public class BoatsToSaveV4 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        int numberOfBoats = minimumNUmberOfBoats(arr, 3);
        System.out.println(numberOfBoats);
    }

    private static int minimumNUmberOfBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int leftPerson =0;
        int rightPerson = arr.length-1;
        int numberOfBoats = 0;

        while(leftPerson <= rightPerson) {
            numberOfBoats++;
            if(arr[leftPerson] + arr[rightPerson] <= limit) {
                leftPerson++;
            }
            rightPerson--;
        }
        return numberOfBoats;
    }
}
