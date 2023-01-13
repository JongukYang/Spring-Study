package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 추상화에도 의존하고 구현체에도 의존함 DIP 위반 -> 설계 오류
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * AppConfig를 통한 해결 방법
     * 생성자를 통해서 Repository 구현체에 뭐가 들어갈지 생성자를 통해 구현
     * 따라서 구현체 클래스에는 Interface만 존재하게 되어서 DIP를 지키게 됨
     */
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)처럼 동작함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // AppConfig에서 생성되어 주입되는 친구들 Singleton 형식인지 알아보기 위한 테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
