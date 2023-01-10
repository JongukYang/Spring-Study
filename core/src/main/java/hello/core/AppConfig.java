package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring으로 바꿔보기
@Configuration
public class AppConfig {
    /**
     * DIP와 OCP를 지키게 하기 위한 인터페이스를 연결해주는 클래스
     *
     * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
     *
     * 누군가 AppConfig를 통해 클래스를 불러다 쓰는데 그 생성자에 여기서 만들어서 넣어줌
     * 생성자를 통해 객체가 생성됨 -> 이거를 '생성자 주입' 이라고 함
     */
    // AppConfig Refactoring -> Command + Option + M
    // Bean 을 붙여주면 Spring Container 에 붙게 됨
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 리펙토링한 메소드, 역할이 잘 보이게 함 / new로 호출이 아닌 메소드 호출 / 중복 제거
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    // 메소드 명을 가지고 역할을 보기 쉽게 명시해줌
    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 방식 바꾸기 -> AppConfig를 사용하기 때문에 정말 쉽게 알아볼 수 있고 변경도 쉬움 -> 객체지향의 장점
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
