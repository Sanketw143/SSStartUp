package org.ssupstart.datastructure.twopointeralgo.leetcodes.containerofwater11;



//You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:
//
//Input: height = [1,1]
//Output: 1
//Input: height = [1,2,3]
//Output: 4

public class ContainerWithMostWater11V2 {
//                 0 1 2 3 4 5 6 7 8
//Input: height = [1,8,6,2,5,4,8,3,7]
//iteration 1
//                 s               e
// minBar = 1;
// width = 8;
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:


    public static void main(String[] args) {
        int[] input = {1,1};
        int maxAmtWater = getMaxAmtWater(input);
    }

    private static int getMaxAmtWater(int[] input) {
        int start = 0;
        int end = input.length-1;
        int result = Integer.MIN_VALUE;

        while(start<end) {
            result = Math.max(result, (Math.min(input[start],input[end])) * (end-start));
            if(input[start] < input[end])
                start++;
            else
                end--;
        }
        return result;
    }
}
