package org.ssupstart.datastructure.top150questionsleetcode.jumpgamesBAKI910;

public class JumpGame45 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int result = minimumJump(arr);
        System.out.println(result);
    }

    private static int minimumJumpV2(int[] arr){

        return 0;
    }

    private static int minimumJump(int[] arr) {
        int result = 0;
        int endOfCurrentWindow = 0;//each window one jump
        int farthest = 0;
        for(int i=0; i<arr.length-1; i++) {
            farthest = Math.max(farthest, i+arr[i]);
            if(farthest >= arr.length-1) {
                result++;
                return result;
            }
            if(i == endOfCurrentWindow) {
                result++;
                endOfCurrentWindow = farthest;
            }
        }
        return result;
    }
}
