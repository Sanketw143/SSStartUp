package org.ssupstart.datastructure.intervals.mergerintervels56;

import java.util.Arrays;

public class MergeInterval56V2 {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(arr);
        System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }

    private static int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        int totalInputIntervals = arr.length;
        int[][] res = new int[totalInputIntervals][2];
        res[0] = arr[0];
        int e=0;
        for(int i=1; i<totalInputIntervals; i++) {
            if(arr[i][0] <= res[e][1]) {
                res[e][1] = Math.max(arr[i][1], res[e][1]);
            } else {
                e++;
                res[e] = arr[i];
            }
        }
        return Arrays.copyOfRange(res,0,e+1);
    }

}
