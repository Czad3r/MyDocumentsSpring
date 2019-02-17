package info.kowalczuk.spring.impl.aop;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsLoggingModule implements ThrowsAdvice {
    private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {

            log.debug(() ->"@@@(THROWS) Wywołana metoda: " + m.getName());
            if (args.length == 0)
                log.debug(() ->"@@@@(THROWS) Nie przekazano argumentów.");
            for (Object arg : args)
                log.debug(() ->"@@@@(THROWS) Przekazany argument:" + arg);
            log.debug(() ->"@@@(THORWS) Błąd: " + ex.getMessage());

    }
}
