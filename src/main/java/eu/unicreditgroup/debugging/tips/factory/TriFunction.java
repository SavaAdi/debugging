package eu.unicreditgroup.debugging.tips.factory;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}
