package com.examples.com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    @Before(
            "execution(* *.runForMe(..))"
    )
    public void startingExecution() {
        System.out.println("Entering method..");
    }

}
