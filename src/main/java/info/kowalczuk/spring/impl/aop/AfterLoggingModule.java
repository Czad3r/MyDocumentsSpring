package info.kowalczuk.spring.impl.aop;

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

    }
}
