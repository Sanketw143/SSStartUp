package org.ssupstart.datastructure.top150questionsleetcode.buysellstockBAKI78;

/*Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
*/
public class BuySellStock122 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int profit = buySellStockManyV2(arr);
        System.out.println(profit);
    }
    private static int buySellStockManyV2(int[] arr) {
        int buy = arr[0];
        int profit =0;
        for (int price : arr) {
            if(price > buy) {
                profit += (price - buy);
            }
            buy = price;
        }
        return profit;
    }


    private static int buySellStockMany(int[] arr) {
        int buy = arr[0];
        int profit = 0;
        for(int price : arr) {
            if(price > buy) {
                profit += (price - buy);
            }
            buy = price;
        }
        return profit;
    }

}
