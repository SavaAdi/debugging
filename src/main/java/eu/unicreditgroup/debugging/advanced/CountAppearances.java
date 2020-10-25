package eu.unicreditgroup.debugging.advanced;

import java.util.*;

public class CountAppearances {

    static List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 10, 2, 100, 7, 7, 7));

    public static Map<Integer, Long> countAppearances(List<Integer> list){
        Map<Integer, Long> nrCount = new HashMap<>();

        list.forEach(n -> {
            if (nrCount.containsKey(n)) {
                nrCount.put(n, nrCount.get(n) + 1L);
            } else {
                nrCount.put(n, 1L);
            }
        });

        return nrCount;
    }

    public static void main(String[] args) {
        System.out.println(countAppearances(test));
    }
}
