package org.ssupstart.datastructure.Arrays.BuySellStock;

import org.ssupstart.Main;

public class BuySellStock {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        int maxProfit = getMaxProfit(arr);
        System.out.println(maxProfit);
    }

    private static int getMaxProfit(int[] arr) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i< arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }
}
