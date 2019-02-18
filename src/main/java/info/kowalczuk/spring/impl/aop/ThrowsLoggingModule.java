package info.kowalczuk.spring.impl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThrowsLoggingModule {
    private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);

    @AfterThrowing(pointcut = "execution(* info.kowalczuk.spring.impl.service.MySearchEngine.*(..))",
            throwing = "ex")
    public void afterThrowing(JoinPoint pjp, UnsupportedOperationException ex) {

        log.debug(() -> "@@@(THROWS) Wywołana metoda: " + pjp.getSignature().getName());
        if (pjp.getArgs().length == 0)
            log.debug(() -> "@@@@(THROWS) Nie przekazano argumentów.");
        for (Object arg : pjp.getArgs())
            log.debug(() -> "@@@@(THROWS) Przekazany argument:" + arg);
        log.debug(() -> "@@@(THROWS) Błąd: " + ex);

    }
}
