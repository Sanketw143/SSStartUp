package org.ssupstart.datastructure.first1.twopointeralgo.cycledetection.happynumber;

//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly
// in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.

import java.util.HashSet;

//Input: n = 19
//Output: true
//Explanation:
//        12 + 92 = 82
//        82 + 22 = 68
//        62 + 82 = 100
//        12 + 02 + 02 = 1
//Example 2:
//
//Input: n = 2
// 2>>4>>16>37>>58>>89>>145>>42>>20>>4
//Output: false
public class Practice {

    public static boolean isHappy(int n) {
        HashSet<Integer> everySum = new HashSet<>();
        while(n!=1 && !everySum.contains(n)) {
            everySum.add(n);
            n = getSum(n);
        }
        return n==1;
    }

    public static int getSum(int n) {
        int result=0;
        while(n!=0) {
            int reminder = n%10;
            n = n/10;
            result = result + (reminder * reminder);
        }
        return result;
    }
}
