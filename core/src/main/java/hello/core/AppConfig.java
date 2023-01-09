package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    /**
     * DIP와 OCP를 지키게 하기 위한 인터페이스를 연결해주는 클래스
     *
     * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
     *
     * 누군가 AppConfig를 통해 클래스를 불러다 쓰는데 그 생성자에 여기서 만들어서 넣어줌
     * 생성자를 통해 객체가 생성됨 -> 이거를 '생성자 주입' 이라고 함
     */
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }

}
