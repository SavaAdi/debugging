package eu.unicreditgroup.debugging.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cat extends Feline { // <<1.3>>

    public static String attribute = "Smart and lazy creature";  // <<1.1>>
    public Color color = Color.WHITE;
    public String name = "Stray-cat"; // <<1.3>>
    private boolean isTired = false;

    public static void main(String[] args) {
        Cat someCat = Cat.builder()
                .color(Color.BLACK)
                .name("Pixie")
                .build();
        Cat anotherCat = new Cat();

//        int c = 3 / 0;  // <<1.4>>
//        Cat noCat = Cat.builder()  // <<1.4>>
//                .color(null)
//                .build();
//        System.out.println(noCat.color.toString());

//

        anotherCat.play();
        someCat.play();
        System.out.println(someCat);  // <<1.5>>
        System.out.println(someCat.getName());
        System.out.println(someCat.purr());
    }

    public void play() { // <<1.2>>
        System.out.println("The cat is playing");
        becomeTired();
        var tired = isTired ? "tired" : "not tired";
        System.out.println("Now it's " + tired);
    }

    public void becomeTired() {
        this.isTired = !isTired;
    }

    @Override
    public void sleep() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Took a good nap");
    }

    @Override
    public String talk(String message) {
        return message;
    }

    @Override
    public void eat() {
        System.out.println("Eats");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", isTired=" + isTired +
                '}';
    }
}
