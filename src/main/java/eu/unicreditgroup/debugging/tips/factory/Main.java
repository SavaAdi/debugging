package eu.unicreditgroup.debugging.tips.factory;

public class Main {

    public static void main(String[] args) {

        Gac gac = (Gac) MelonFactory.newInstance(Gac.class);        
        Melon melon = (Melon) MelonFactory.newInstance("Gac", 2000, "red");        
        
        System.out.println("Gac: " + gac.toString());
        System.out.println("Melon: " + melon);
    }
    
}
