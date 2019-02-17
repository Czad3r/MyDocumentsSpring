package info.kowalczuk.spring.impl.aop;

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
            log.info(() -> "@@@@(BEFORE) Przekazany argument:" + arg);

    }
}
