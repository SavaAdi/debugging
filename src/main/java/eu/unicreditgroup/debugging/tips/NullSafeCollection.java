package eu.unicreditgroup.debugging.tips;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class NullSafeCollection {
    public static final Integer[] mixedCollection= {1, null, 2, 3, null};

    public static <T> Stream<T> collectionAsStreamWithoutNulls(
            Collection<T> collection) {
        return collection.stream().flatMap(Stream::ofNullable);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(collectionAsStreamWithoutNulls(Arrays.asList(mixedCollection)).toArray()));
    }
}
