package info.kowalczuk.spring.impl.aop;

<<<<<<< HEAD
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterLoggingModule {
    private static final Logger log = LoggerFactory.getLogger(AfterLoggingModule.class);

    @After("execution(* info.kowalczuk.spring.impl.service.MySearchEngine.*(..))")
    public void afterReturning(JoinPoint pjp) throws Throwable {
        log.info(() -> "@@@@(AFTER) Wywołana metoda: " + pjp.getSignature().getName());
        if (pjp.getArgs().length == 0)
            log.info(() -> "@@@@(AFTER) Nie przekazano argumentów.");
        for (Object arg : pjp.getArgs())
            log.info(() -> "@@@@(AFTER) Przekazany argument:" + arg);
        ;
=======
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLoggingModule implements AfterReturningAdvice {
    private static final Logger log = LoggerFactory.getLogger(AfterLoggingModule.class);

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info(() -> "@@@@(AFTER) Wywołana metoda: " + method.getName());
        if (args.length == 0)
            log.info(() -> "@@@@(AFTER) Nie przekazano argumentów.");
        for (Object arg : args)
            log.info(() -> "@@@@(AFTER) Przekazany argument:" + arg);
        log.info(() -> "@@@(AFTER) Wynik: " + returnValue);
>>>>>>> Added aop logging with xml config.

    }
}
