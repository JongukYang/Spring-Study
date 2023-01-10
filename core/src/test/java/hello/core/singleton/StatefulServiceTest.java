package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /**
         * 싱글톤 설계 오류 코드
         */
//        // Thread A : A 사용자가 10_000원 주문
//        statefulService1.order("userA", 10000);
//        // Thread B : B 사용자가 20_000원 주문
//        statefulService2.order("userB", 20000);
//
//        // Thread A : A 사용자가 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//        // A는 10_000원이어야 하는데 결과는 20_000원이 나옴. 문제가 있음
//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
//
//        // !!! 특정 Client가 값을 변경하게 하면 안됨 !!! -> StatefulService 설계 변경


        /**
         * 싱글톤 방식으로 변경
         * 지역변수로 변경했기 때문에 실행하고 사라짐
         */
        // Thread A : A 사용자가 10_000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // Thread B : B 사용자가 20_000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // 사용자가 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);
//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}