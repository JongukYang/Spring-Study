package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

        // 컴포넌트 스캔을 시작할 패키지 지정 가능 (여러개 지정도 가능)
        basePackages = "hello.core",
        // 지정한 클래스와 연동된 패키지 다 찾아봄
        basePackageClasses = AutoAppConfig.class,
        // 예제를 위해 AppConfig 파일과 안겹치게 exclude
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
