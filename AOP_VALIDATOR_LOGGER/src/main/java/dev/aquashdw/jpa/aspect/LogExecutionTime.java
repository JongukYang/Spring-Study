package dev.aquashdw.jpa.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 함수(target)에 붙기 위한 어노테이션 이라는 뜻
@Retention(RetentionPolicy.RUNTIME) // 실행될 때 어느 시점까지 존재할 것인지
public @interface LogExecutionTime {
}
