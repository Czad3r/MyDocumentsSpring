package info.kowalczuk.spring.impl.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class AroundLoggingModule implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AroundLoggingModule.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;

        log.debug(() -> "@@@@(AROUND-BEFORE) Wywołana metoda: " +
                invocation.getMethod().getName());
        if (invocation.getArguments().length == 0)
            log.debug(() -> "@@@@(AROUND-BEFORE) Nie przekazano argumentów.");
        for (Object arg : invocation.getArguments())
            log.debug(() -> "@@@@(AROUND-BEFORE) Przekazany argument:" + arg);

        try {
            log.debug(() -> "@@@(AROUND) Przetwarzanie...");
            result = invocation.proceed();
            Object finalResult = result;
            log.debug(() -> "@@@(AROUND-AFTER) Wynik: " + finalResult);
            return result;
        } catch (IllegalArgumentException ex) {
            log.error(() -> "@@@(AROUND) Zgłasza wyjątek: " + ex.getMessage());
            throw ex;
        }
    }
}
