package eu.unicreditgroup.debugging.playtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyExample {

    static final List LIST = Collections.synchronizedList(new ArrayList());

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> addIfAbsent(13));
        t.start();
        addIfAbsent(13);
        t.join();
        System.out.println(LIST);
    }

    private static void addIfAbsent(int x) {
        if (!LIST.contains(x)) {
            LIST.add(x);
        }
    }
}
