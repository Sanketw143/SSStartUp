package org.ssupstart.datastructure.top150questionsleetcode.buysellstockBAKI78;

public class BuySellStock121 {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = buySellStockV2(arr);
        System.out.println(result);
    }

    private static int buySellStockV2(int[] arr) {
        int buy=0;
        int profit =0;
        for(int price : arr) {
            if(price < buy) {
                buy = price;
            } else if(price - buy > profit) {
                profit = price-buy;
            }
        }
        return profit;
    }

    private static int buySellStock(int[] arr) {
        int buy=Integer.MAX_VALUE;
        int profit = 0;

        for(int price : arr) {
            if(price < buy) {
                buy = price;
            } else if (price - buy > profit) {
                profit = price - buy;
            }
        }
        return profit;
    }
}
