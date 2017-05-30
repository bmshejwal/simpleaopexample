package com.examples.com.aspect;

import com.examples.com.EntityNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @After("execution(* insert(..))")
    public void beforeInserting(final JoinPoint joinPoint) {
        System.out.println("Entity is being inserted for: " + joinPoint.getSignature());
    }

    @After("execution(* delete(..))")
    public void afterDeleting(final JoinPoint joinPoint) {
        final Object[] arguments = joinPoint.getArgs();
        System.out.println("Entity is being deleted: " + arguments[0]);
    }

    @AfterThrowing(
            pointcut = "execution(* update(..))",
            throwing = "ex")
    public void getAnyException(final EntityNotFoundException ex) {
        System.out.println("Some problem in the system! Will get back soon!");
    }

    @Around("execution(* update(..))")
    public void handleUpdate(final ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (final Throwable throwable) {
            System.out.println("Suppressing the exception! Update cannot be handled this time!");
        }
    }

    @Around("execution(* *(int))")
    public Object handleCalculation(final ProceedingJoinPoint joinPoint) {
        try {
            final Object[] arguments = joinPoint.getArgs();
            final int val = (Integer) arguments[0];
            if (val < 0) {
                System.out.println("Cannot multiply negative input!");
            } else {
                return joinPoint.proceed();
            }
        } catch (final Throwable throwable) {
            System.out.println("Suppressing the exception! Update cannot be handled this time!");
        }
        return Integer.MIN_VALUE;
    }

}
