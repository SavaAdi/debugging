package eu.unicreditgroup.debugging.aop;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl {

    @CheckPerformance
    public String importantMethod(String name) throws InterruptedException {
        Thread.sleep(2000);
        if (!name.equals("Forbidden")) {
            return name;
        } else {
            throw new RuntimeException("The name is Forbidden...literally");
        }
    }
}
