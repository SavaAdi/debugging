package eu.unicreditgroup.debugging.tips.strategy;

public final class Remover {

    private Remover() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String remove(String s, RemoveStrategy strategy) {

        if (s == null || strategy == null) {
            throw new IllegalArgumentException("Given string/strategy cannot be null");
        }

        return strategy.execute(s);
    }
}
