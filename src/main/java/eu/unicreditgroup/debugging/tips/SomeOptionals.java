package eu.unicreditgroup.debugging.tips;

import java.util.Optional;

public class SomeOptionals {

    public static void main(String[] args) {
        Optional<Integer> optionalInteger = Optional.of(1); // = ...
        optionalInteger.orElse(1);
        optionalInteger.orElseGet(SomeOptionals::computeDefaultInteger);
    }

    private static Integer computeDefaultInteger() {
        return 1;
    }
}
