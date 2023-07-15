package dev.aquashdw.jpa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // 스프링부트에서는 aspectj라는 것을 사용하여 AOP를 구현함
@Component // 스프링부트에서 Spring Bean으로 등록함
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around(value = "@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis() - startTime;
        logger.info(joinPoint.getSignature() + " executed in " + endTime + "ms");
        logger.info("Proceed : ", proceed.toString());
        return proceed;
    }

    /***
     * @Before 말 그대로 실행 이전에 잠깐 문 두드려보고 슬쩍 보고 가는 느낌
     * 함수가 실행될 때 이름 보고 타입 보고 어디 선언되어있는지 보는거와 같음
     * 그 후에 인자 있으면 출력하고 없으면 뭐 알아서 그런 느낌
     */
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

    /***
     * @AfterReturning
     * 반환값이 존재할 때 사용
     * returning="returnValue" 에서 Object returnValue로 값을 전달
     */
    @AfterReturning(value = "@annotation(LogResults)", returning = "returnValue")
    public void logResults(JoinPoint joinPoint, Object returnValue) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.trace("method: [{}]", methodSignature.getName());
        logger.trace("return type: [{}]", methodSignature.getReturnType());

        logger.trace("return value: [{}]", returnValue);
    }
}
