package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은 필드에 대해 생성자를 자동으로 생성해줌
public class OrderServiceImpl implements OrderService{
    /**
     * 우리는 역할과 구현 충실히 분리하고, 다형성도 활용, 인터페이스를 통해 구현 객체를 분리함
     * 하지만 OCP, DIP 같은 객체지향 설계 원칙을 완벽하게 지킨 것은 아니다.
     *
     * OCP: 변경하지 않고 확장할 수 있다고 했는데
     * 지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! 따라서 OCP를 위반한다.
     *
     * 실제 코드를 보면 클라이언트인 OrderServiceImpl 이 DiscountPolicy 인터페이스 뿐만 아니라
     * FixDiscountPolicy 인 구체 클래스도 함께 의존하고 있다. 실제 코드를 보면 의존하고 있다!  ->  DIP 위반
     *
     * 중요!: 그래서 FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간
     * OrderServiceImpl 의 소스 코드도 함께 변경해야 한다!  ->  OCP 위반
     *
     * 해결 방법 : 인터페이스에만 의존하도록 변경하자 -> 하지만 인터페이스만으로는 아무것도 생성이 되지 않기에 null pointer exception 에러 발생
     * 찐 해결 방법 : 누군가가 클라이언트인 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해주어야 한다.
     *             즉 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자.
     *             AppConfig를 통해 대신 결정되기 때문에 DIP 지킴
     */
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 바꿔끼우기 -> 객체지향의 장점

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    lombok에서 생성자를 자동으로 생성했기 때문에 생략 가능
//    // AppConfig에서 구현 객체를 주입하였음 -> 생성자를 통해 구현 객체 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // SRP 단일 책임 원칙을 잘 지킨 설계 : discount정책에 하나만 책임을 지는 경이우기 때문
        Member member = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 구역으로 member를 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 할인 가격 리턴
    }

    // AppConfig에서 생성되어 주입되는 친구들 Singleton 형식인지 알아보기 위한 테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
