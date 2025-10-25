package org.ssupstart.datastructure.queueandheapREVISIONPENDING.heap.kthsmallestelementinmatrix378;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInMatrix378 {
    public static void main(String[] args) {
        int [] [] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int result = kthSmallest(matrix, 8);
        System.out.println(result);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                pq.add(matrix[i][j]);
                if(pq.size()>k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
