package eu.unicreditgroup.debugging.basic;

public class Guitar extends Instrument {

    int age;

    String name;

    @Override
    public String toString() {
        System.out.println("Hello");
        return "Guitar{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
