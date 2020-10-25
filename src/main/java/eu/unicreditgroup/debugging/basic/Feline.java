package eu.unicreditgroup.debugging.basic;

import lombok.Getter;

@Getter
public abstract class Feline implements Animal{

    private String name = "Feline species";

    public String purr() {
        return "Purr from " + this.name;
    }
}
