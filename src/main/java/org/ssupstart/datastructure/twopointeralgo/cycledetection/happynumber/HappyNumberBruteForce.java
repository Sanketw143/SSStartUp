package org.ssupstart.datastructure.twopointeralgo.cycledetection.happynumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberBruteForce {

    public static void main(String[] args) {
        boolean result = isHappy(2);
        System.out.println(result);
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int remainder = n %10;
            n /=10;
            sum = sum + (int) Math.pow(remainder,2);
        }
        return sum;
    }
}
