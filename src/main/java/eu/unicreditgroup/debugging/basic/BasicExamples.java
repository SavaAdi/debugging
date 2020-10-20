package eu.unicreditgroup.debugging.basic;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BasicExamples {

    private static int sideEffect = 0;

    public static void main(String[] args) {
        Guitar myGuitar = new Guitar();
        myGuitar.age = 3;
        myGuitar.name = "Rex";
        Guitar otherGuitar = new Guitar();
        Guitar theSame = myGuitar;

        log.trace(" " + new BasicExamples().callMeMaybe());
        System.out.println(myGuitar);
        myGuitar.plays();
    }


    public String callMeMaybe() {
        System.out.println("I was called but I don't understand why");
        sideEffect++;
        return "I am here";
    }
}
