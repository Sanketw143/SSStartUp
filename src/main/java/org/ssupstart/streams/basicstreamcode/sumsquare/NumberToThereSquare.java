package org.ssupstart.streams.basicstreamcode.sumsquare;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class NumberToThereSquare {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list = numbers.stream().map(n -> n * n).toList();
        System.out.println(list);
        List<Integer> list1 = numbers.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n).toList();
        System.out.println(list1);

        Stream<Integer> limit = numbers.stream().filter(n -> n > 10).limit(1);
        System.out.println(limit.findFirst().orElse(0));

        Optional<Integer> first = numbers.stream().filter(n -> n > 10).findFirst();
        System.out.println(first.orElse(0));

        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println(count);

        int sum1 = numbers.stream().mapToInt(s -> s).sum();
        System.out.println(sum1);


        Integer reduce = numbers.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
