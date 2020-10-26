package eu.unicreditgroup.debugging.tips;

import java.util.function.Supplier;

public class AwesomeExceptionThrowing {
    String name;
    String color;

    public static <T, X extends Throwable> T requireNonNullElseThrow(
            T obj, X exception) throws X {
        if (obj == null) {
            throw exception;
        }
        return obj;
    }
    public static <T, X extends Throwable> T requireNotNullElseThrow(
            T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if (obj != null) {
            return obj;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public void someMethod(String name, String color) {
        this.name = AwesomeExceptionThrowing.requireNonNullElseThrow(name,
                new UnsupportedOperationException("Name cannot be set as null"));
        this.color = AwesomeExceptionThrowing.requireNotNullElseThrow(color, () ->
                new UnsupportedOperationException("Color cannot be set as null"));
    }

}
