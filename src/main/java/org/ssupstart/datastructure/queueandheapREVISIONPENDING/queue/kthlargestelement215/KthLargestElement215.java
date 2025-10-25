package org.ssupstart.datastructure.queueandheapREVISIONPENDING.queue.kthlargestelement215;


/*Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?*/


import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int resultTwo = kthLargestElementByQueue(arr,2);
        System.out.println(resultTwo);
        //int resultOne = kthLargestElementBySort(arr,2);
        // resulThree = kthLargestElementBySortV2(arr,2);
        //System.out.println(resulThree);
        //System.out.println(resultOne + "     " + resultTwo);
    }

    private static int kthLargestElementBySortV2(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[(arr.length - k)];
    }

    private static int kthLargestElementByQueue(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : arr) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    private static int kthLargestElementBySort(int[] arr, int k) {
        Arrays.sort(arr);
        int i = arr.length;
        while(k>0) {
            i--;
            k--;
        }
        return arr[i];
    }
}
