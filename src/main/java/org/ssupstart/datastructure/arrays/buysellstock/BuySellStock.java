package org.ssupstart.datastructure.arrays.buysellstock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuySellStock {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        log.info("final {}",getMaxProfit(arr));
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
