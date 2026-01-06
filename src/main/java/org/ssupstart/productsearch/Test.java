package org.ssupstart.productsearch;

//Given an array of distinct integers candidates and a
// target integer target, return a list of all unique combinations of
// candidates where the chosen numbers sum to target.
// You may return the combinations in any order.

//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//The test cases are generated such that
// the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//Input: candidates = [2,3,6,7],
//target = 7
//Output: [[2,2,3],[7]]
//Explanation:2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//
//
//
//Input: candidates = [2,3,5],
//target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(6);
        input.add(7);
        int count = getTagetSumCombinations(input,7);
    }

    private static int getTagetSumCombinations(List<Integer> input, int target) {
        int result = 0;
        if(input.get(0) > target) {
            return 0;
        }
        getTagetSumCombinationsHelper(input,target,result);
        return result;
    }

    private static void getTagetSumCombinationsHelper(List<Integer> input, int target, int result) {
        if(target<0) {
            result = 0;
        }

        for(Integer ele : input) {
            if(ele > target) {

            }
            //result +=
        }
    }
}
