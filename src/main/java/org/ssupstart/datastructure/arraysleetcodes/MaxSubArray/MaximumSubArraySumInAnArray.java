package org.ssupstart.datastructure.arraysleetcodes.MaxSubArray;


//ToDo
public class MaximumSubArraySumInAnArray {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        //int maximumSum = getMaximumSubArraySumInNCubeComplexity(arr);
        int maxSum = getMaximumSubArraySumOptimisedWay(arr);
        System.out.println(maxSum);
    }

    private static int getMaximumSubArraySumOptimisedWay(int[] arr) {
        int sum =0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
            if(sum>maxSum) {
                maxSum = sum;
            }
            if(sum<0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    private static int getMaximumSubArraySumInNCubeComplexity(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}
