package org.ssupstart.datastructure.queueandheapREVISIONPENDING.heap.kfreqelements347;

//hashmap.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).mapToInt(Map.Entry :: getValue).limit(k).toArray();
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqElements347 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4};  // 1:3 , 2:2, 3:1, 4:!
        int[] resultTwo = topKFreqElementsByPriorityQueue(arr, 2);
        int[] result = topKFreqElementsUsingHashmapAndStreams(arr, 2);

        System.out.println(Arrays.toString(result));
    }

    private static int[] topKFreqElementsByPriorityQueue(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a), map.get(b)));

        for(int key : map.keySet()) {
            queue.add(key);
            if(queue.size()>k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for(int i=k-1; i>=0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }

    private static int[] topKFreqElementsUsingHashmapAndStreams(int[] arr, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int num : arr) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        return hashmap.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).mapToInt(Map.Entry :: getKey).limit(k).toArray();
    }
}
