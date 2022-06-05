package com.portifolyo.atmproject.aspects;

import com.portifolyo.atmproject.annotation.Validate;
import com.portifolyo.atmproject.api.v1.AdminApi;
import com.portifolyo.atmproject.exceptions.ValidationError;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Aspect
@Component
public class ValidateAspect {

    private Logger logger;

    private final ApplicationContext applicationContext;

    public ValidateAspect(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Before(value = "@annotation(com.portifolyo.atmproject.annotation.Validate)")
    public void before(JoinPoint joinPoint) throws Exception, ValidationError {


        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getMethod().getAnnotation(Validate.class).validator().getText();
        Object[] o = joinPoint.getArgs();
        Class clazz = applicationContext.getBean(className).getClass();
        String controllerName = joinPoint.getThis().getClass().getName();
        controllerName = controllerName.contains("$$") ? controllerName.substring(0,controllerName.indexOf("$$"))  : controllerName;
        Class controller = Class.forName(controllerName);
        Field ischecked = controller.getDeclaredField("isChecked");
       // ischecked.setAccessible(true);
        ischecked.set(joinPoint.getThis(),true);
        //controller.getField("isChecked").setBoolean(joinPoint.getThis(),true);

        // şimdi hata burda AdminApi'deki field'i değiştirmemize rağmen AdminApide yine default olarak değer gidiyo
        // aşağıdaki if içerisine girmeden false olarak gidiyo nedense


        boolean result = (boolean) clazz.getMethod("validate", o[0].getClass()).invoke(applicationContext.getBean(className), o[0]);

        if (!result) {
            logger = LoggerFactory.getLogger(joinPoint.getThis().getClass());
            logger.error("Validation Error {}", joinPoint.getArgs()[0]);
          //  controller.getField("isChecked").setBoolean(joinPoint.getThis(),false);
            ischecked.set(joinPoint.getThis(),false);
        }
    }
}

