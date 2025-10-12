package org.ssupstart.datastructure.binarysearch.shippackages1011;



/*A conveyor belt has packages that must be shipped from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt
(in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.*/

import java.util.Arrays;

public class ShipPackagesWithinDdays1011 {

    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6,7,8,9,10};
        int min = shipWithinDays(weight,5);
        System.out.println(min);
    }

//    Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//    Output: 15
//    Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//            1st day: 1, 2, 3, 4, 5
//            2nd day: 6, 7
//            3rd day: 8
//            4th day: 9
//            5th day: 10


//    Input: weights = [3,2,2,4,1,4], days = 3
//    Output: 6
//    Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
//            1st day: 3, 2
//            2nd day: 2, 4
//            3rd day: 1, 4
    public static int shipWithinDays(int[] weights, int days) {
        int minWeight = getMinWeight(weights);
        int maxWeight = getMaxWeight(weights);
        int result = maxWeight;
        while(minWeight<=maxWeight) {
            int mid = (maxWeight+minWeight)/2;
            if(canShip(weights,days,mid)) {
                result = mid;
                maxWeight = mid-1;
            } else {
                minWeight = mid+1;
            }
        }
        return result;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int totalWeight =0;
        int dayCount = 1;
        for(int weight : weights) {
            if(totalWeight + weight > capacity) {
                dayCount++;
                totalWeight = weight;
            } else {
                totalWeight += weight;
            }
        }
        return dayCount<=days;
    }

    private static int getMaxWeight(int[] weights) {
        return Arrays.stream(weights).sum();
    }

    private static int getMinWeight(int[] weights) {
        return Arrays.stream(weights).max().orElse(0);
    }
}
