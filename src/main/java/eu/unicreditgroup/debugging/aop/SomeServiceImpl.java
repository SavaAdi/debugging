package eu.unicreditgroup.debugging.aop;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl {

    @CheckPerformance
    public String importantMethod() throws InterruptedException {
        Thread.sleep(2000);

        return "Done";
    }
}
