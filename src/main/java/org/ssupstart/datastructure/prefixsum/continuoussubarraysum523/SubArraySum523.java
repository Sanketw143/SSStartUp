package org.ssupstart.datastructure.prefixsum.continuoussubarraysum523;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum523 {
    public static void main(String[] args) {
        int[] arr = {23,2,4,6,7};
        boolean result = checkGoodSumArray(arr, 6);
    }

    private static boolean checkGoodSumArray(int[] arr, int k) {
        Map<Integer,Integer> reminderAndIndexmap = new HashMap<>();
        reminderAndIndexmap.put(0,-1);
        int sum=0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            int reminder = sum % k;
            if(reminderAndIndexmap.containsKey(reminder)) {
                if(i - reminderAndIndexmap.get(reminder) > 1) {
                    return true;
                }
            } else {
                reminderAndIndexmap.put(reminder, i);
            }
        }
        return false;
    }
}
