package org.ssupstart.datastructure.top150questionsleetcode.jumpgamesBAKI910;

public class JumpGames55 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        boolean canReach = canReachableV3(arr);
        System.out.println(canReach);
    }

    public static boolean canReachableV3(int[] arr) {
        int reachable=0;
        for(int i=0; i<arr.length; i++) {
            reachable = Math.max(reachable, i+arr[i]);
            if (reachable >= arr.length-1) {
                return true;
            }
        }
        return false;
    }




    private static boolean canReachableV2(int[] arr) {
        int reachable = 0;
        for(int i=0; i<arr.length;i++) {
            reachable = Math.max(reachable, i+arr[i]);
            if(reachable >= arr.length-1) {
                return true;
            }
        }
        return false;
    }


    private static boolean canReachable(int[] arr) {
        int reachable = 0;
        for(int i=0; i<arr.length; i++) {
            reachable = Math.max(reachable, i+arr[i]);
            if(reachable >= arr.length-1) {
                return true;
            }
        }
        return false;
    }

}
