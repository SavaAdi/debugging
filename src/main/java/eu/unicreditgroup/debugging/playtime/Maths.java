package eu.unicreditgroup.debugging.playtime;

public class Maths {  // <<4.3>>

    public static void main(String[] args) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        long z = x + y;
        System.out.println("Sum is: " + z);

        long z2 = Math.addExact(x, y);
        System.out.println("The actual sum is: " + z2);
    }
}
