package fr.esgi.aquarium.infra.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class ControllerAspect {

    @Pointcut(value = "execution(* fr.esgi.aquarium.infra.web.api.*.*(..))")
    public void executeLogging() {
        //Execute Logging
    }

    @Around("executeLogging()")
    public Object loggingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        String className = "CLASS: [" + joinPoint.getTarget().getClass().getSimpleName() + "],";
        String methodName = " METHOD: [" + joinPoint.getSignature().getName() + "()],";
        log.info(className + methodName + " REQUEST: ");
        if (joinPoint.getArgs().length > 0) {
            Arrays.stream(joinPoint.getArgs()).map(Object::toString).forEach(log::info);
        } else {
            log.info("[]");
        }
        log.info(className + methodName + " RESPONSE: " + proceed.toString());
        return proceed;
    }
}
