package info.kowalczuk.spring.impl.aop;

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
            log.info(() -> "@@@@(BEFORE) Przekazany argument:" + arg);

    }
}
