package org.ssupstart.streams.basicstreamcode.distinctother;

import java.util.Arrays;
import java.util.List;

public class BasicStreamPartTwo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        System.out.println(averageOfNumbers(nums));
    }

    private static double averageOfNumbers(List<Integer> nums) {
        return nums.stream().mapToDouble(Integer :: intValue).average().getAsDouble();
    }

}
