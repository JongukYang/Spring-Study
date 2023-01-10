package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    /**
     * Spring Container 는 싱글톤 패턴의 문제점을 해결하면서,
     * 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다.
     * 지금까지 우리가 학습한 스프링 빈이 바로 싱글톤으로 관리되는 빈이다.
     */

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조 값이 다른 것을 확인해보자
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1은 memberservice2 랑 달라야 한다! -> why? 호출할 때 마다 맴버 서비스 새로 생성함 -> 출력 메모리 주소 보면 앎
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱슬톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 출력 메모리 주소값 보면 동일한 것을 제공하는걸 알 수 있음
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        // same 과 equal
        // same : == 비교, 진짜 같은지(메모리 주소가)
        // equal : 문자열 비교
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조 값이 다른 것을 확인해보자
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1은 memberservice2 랑 달라야 한다! -> why? 호출할 때 마다 맴버 서비스 새로 생성함 -> 출력 메모리 주소 보면 앎
        assertThat(memberService1).isSameAs(memberService2);
    }
}
