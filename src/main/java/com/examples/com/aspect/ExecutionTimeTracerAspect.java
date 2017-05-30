package com.examples.com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTracerAspect {

    @Around("@annotation(com.examples.com.annotation.TimeTracer)")
    public Object logTime(final ProceedingJoinPoint joinPoint) {
        final long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (final Throwable throwable) {
            throwable.printStackTrace();
        }
        final long totalTimeTaken = System.currentTimeMillis() - start;
        System.out.println("Time taken for method " + joinPoint.getSignature() + ": " + totalTimeTaken);
        return proceed;
    }
}
