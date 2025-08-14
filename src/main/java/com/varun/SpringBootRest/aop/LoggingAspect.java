package com.varun.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingAspect.class);

    //Syntax:  return-type fully-qualified-class-name.method-name(args)

    @Before("execution(* com.varun.SpringBootRest.services.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.varun.SpringBootRest.services.JobService.getAllJobs(..))" +
            "|| execution(* com.varun.SpringBootRest.services.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.varun.SpringBootRest.services.JobService.getAllJobs(..))" +
            "|| execution(* com.varun.SpringBootRest.services.JobService.updateJob(..))")
    public void logMethodExecutedAfterThrowing(JoinPoint jp) {
        LOGGER.info("Method Executed after throwing: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.varun.SpringBootRest.services.JobService.getAllJobs(..))" +
            "|| execution(* com.varun.SpringBootRest.services.JobService.updateJob(..))")
    public void logMethodExecutedAfterReturning(JoinPoint jp) {
        LOGGER.info("Method Executed after returning: " + jp.getSignature().getName());
    }

}
