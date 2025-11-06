package org.ssupstart.datastructure.first1.twopointeralgo.leetcodes.containerofwater11.DONE;

public class ContainerWithMostWater11V3 {
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
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaV3(heights));
    }

    private static int maxAreaV3(int[] heights) {
        int start=0;
        int end =heights.length-1;
        Integer area = Integer.MIN_VALUE;

        while (start<=end) {
            area = Math.max(area,Math.max(heights[start], heights[end]) * (end-start));
            if(heights[start] < heights[end])
                start++;
            else
                end--;
        }
        return area;
    }
}