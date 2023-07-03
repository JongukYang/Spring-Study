package dev.aquashdw.jpa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // @Around : @LogExecutionTime 어노테이션이 붙어있는 함수에 대해 실행됨
    @Around(value = "@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis() - startTime;
        logger.info(joinPoint.getSignature() + " executed in " + endTime + "ms");
        return proceed;
//        2023-07-03 22:53:25.725  INFO 38304 --- [nio-8080-exec-1] dev.aquashdw.jpa.aspect.LoggingAspect    : List dev.aquashdw.jpa.PostController.readPostAll() executed in 136ms
    }


    @Before(value = "@annotation(LogArguments)")
    public void logParameters(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method description: [{}]", methodSignature.getMethod());
        logger.trace("method name: [{}]", methodSignature.getName());
        logger.trace("declaring type: [{}]", methodSignature.getDeclaringType());

        Object[] arguments = joinPoint.getArgs();
        if (arguments.length == 0) {
            logger.trace("no arguments");
        }
        for (Object argument: arguments){
            logger.trace("argument: [{}]", argument);
        }
    }

    // @AfterReturning 반환값이 존재하는 것들에 대해서 point cut을 해줄 수 있음
    // returning="returnValue" 라는 이름을 가진 것을 Object returnValue 에 대입해줌
    @AfterReturning(value = "@annotation(LogResults)", returning = "returnValue")
    public void logResults(JoinPoint joinPoint, Object returnValue) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.trace("method: [{}]", methodSignature.getName());
        logger.trace("return type: [{}]", methodSignature.getReturnType());

        logger.trace("return value: [{}]", returnValue);
    }
}
