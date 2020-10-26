package eu.unicreditgroup.debugging.tips;

import java.util.Objects;

//Checking null references and returning
//non-null default references
public class CheckNullGetDefault {

    private final String name;
    private final String color;

    public CheckNullGetDefault(String name, String color) {
        this.name = Objects.requireNonNullElseGet(name,() -> "No name");
        this.color = Objects.requireNonNullElseGet(color, () -> "Nigger");
    }

    public static void main(String[] args) {
        String test = "Adi";

    }

}
