package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.containerofwater11.DONE;


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


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int result = Integer.MIN_VALUE;

        while (start<end) {
            result = Math.max(result,Math.min(height[start], height[end]) * (end-start));
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return result;
    }
}
