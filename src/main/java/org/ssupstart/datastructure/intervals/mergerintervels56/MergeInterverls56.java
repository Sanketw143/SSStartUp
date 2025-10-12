package org.ssupstart.datastructure.intervals.mergerintervels56;


//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
//and return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.Arrays;

public class MergeInterverls56 {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(arr);
        System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int n = intervals.length;
        int[][] result = new int[n][2];
        result[0] = intervals[0];
        int e=0;
        for(int i=1; i<n; i++) {
            if(intervals[i][0] <= result[e][1]) {
                result[e][1] = Math.max(intervals[i][1],result[e][1]);//comparing last element of both intervals
            } else {
                e++;
                result[e] = intervals[i];
            }
        }
        return Arrays.copyOfRange(result,0,e+1);
    }
}
