package com.portifolyo.atmproject.aspects;

import com.portifolyo.atmproject.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private Logger log;

    @After(value = "@annotation(com.portifolyo.atmproject.annotation.Log)")
    public void logAfter(JoinPoint jp) {

        log = LoggerFactory.getLogger(jp.getThis().getClass());
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String template = methodSignature.getMethod().getAnnotation(Log.class).log();
        log.info(template,jp.getArgs()[0]);

    }

    @AfterThrowing(pointcut = "@annotation(com.portifolyo.atmproject.annotation.Log)" , throwing = "ex")
    public void logThrowingAfter(JoinPoint jp ,Throwable ex) {
        log = LoggerFactory.getLogger(jp.getThis().getClass());
        log.error(jp.getThis().getClass().getAnnotation(Log.class).log(),ex);
    }

}
