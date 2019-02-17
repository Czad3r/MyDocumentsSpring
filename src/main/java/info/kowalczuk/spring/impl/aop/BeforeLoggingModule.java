package info.kowalczuk.spring.impl.aop;

<<<<<<< HEAD
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeLoggingModule {
    private static final Logger log = LoggerFactory.getLogger(BeforeLoggingModule.class);

    @Before("execution(* info.kowalczuk.spring.impl.service.MySearchEngine.*(..))")
    public void before(JoinPoint pjp) throws Throwable {
        log.info(() -> "@@@@(BEFORE) Wywołana metoda: " + pjp.getSignature().getName());
        if (pjp.getArgs().length == 0)
            log.info(() -> "@@@@(BEFORE) Nie przekazano argumentów.");
        for (Object arg : pjp.getArgs())
=======
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class BeforeLoggingModule implements MethodBeforeAdvice {
    private static final Logger log = LoggerFactory.getLogger(BeforeLoggingModule.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info(() -> "@@@@(BEFORE) Wywołana metoda: " + method.getName());
        if (args.length == 0)
            log.info(() -> "@@@@(BEFORE) Nie przekazano argumentów.");
        for (Object arg : args)
>>>>>>> Added aop logging with xml config.
            log.info(() -> "@@@@(BEFORE) Przekazany argument:" + arg);

    }
}
