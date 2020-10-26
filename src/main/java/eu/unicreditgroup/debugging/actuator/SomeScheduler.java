package eu.unicreditgroup.debugging.actuator;

import org.springframework.scheduling.annotation.Scheduled;


public class SomeScheduler {

    @Scheduled(fixedRate = 2000)
    public void saySomething() {
        System.out.println("Printing stuff every 2 seconds");
    }
}
