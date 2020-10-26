package eu.unicreditgroup.debugging.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LotsOfLambdas {

    static List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 3, 2, 3, 4, 8, 6, 7, 8, 9, 11, 33));

    public static void main(String[] args) {
        someLambdaMethod(3).forEach(System.out::println); // <<2.5>>
        String str = "Me and my twin"; // <<2.7>>
    }

    public static List<Integer> someLambdaMethod(int n) {
        List<Integer> onlyOddAndGreaterThanN = numbers.parallelStream()
                .filter(nr -> nr % 2 != 0)
                .filter(nr -> nr > n)
                .distinct()
//                .sorted()
                .peek(nr -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Nr is: " + nr);
        }).collect(toList());  // <<2.4>>

        return onlyOddAndGreaterThanN; // <<2.8>
    }
}
