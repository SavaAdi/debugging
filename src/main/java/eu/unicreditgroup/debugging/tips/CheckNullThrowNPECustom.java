package eu.unicreditgroup.debugging.tips;

import java.util.Objects;

//Checking null references and throwing a customized
//NullPointerException error: Write a program that performs the null
//checks on the given references and throws NullPointerException with
//custom messages.
public class CheckNullThrowNPECustom {

    public void assignDriver(String license, Integer location) {
        Objects.requireNonNull(license,() -> "License cannot be null");
        Objects.requireNonNull(location, () -> "Location cannot be null");
    }


}
