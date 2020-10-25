package eu.unicreditgroup.debugging.aop.example;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExample {

    @Pointcut("execution(* eu.unicreditgroup.debugging.aop.SomeServiceImpl.importantMethod(..))")
    public void doSomething() { }

    @Before("eu.unicreditgroup.debugging.aop.example.AopExample.doSomething() && args(name)")
    public void logBeforeMethod(String name) {
        System.out.println("This is before importantMethod: name: " + name);
    }

    @AfterReturning(value = "eu.unicreditgroup.debugging.aop.example.AopExample.doSomething()",
            returning = "name")
    public void logAfterMethod(String name) {
        System.out.println("This is after the Authenticate Method authentication: " + name);
    }

    @AfterThrowing("eu.unicreditgroup.debugging.aop.example.AopExample.doSomething() && args(name)")
    public void logMethodException(String name) {
        System.out.println("Throw error for name: " + name);
    }
}
