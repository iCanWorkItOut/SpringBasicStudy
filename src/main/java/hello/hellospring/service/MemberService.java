package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    // MemberService를 @Service 애노테이션으로 설정하여, 스프링 컨테이너에 빈으로 등록 : 인스턴스를 스프링에서 관리해 줌
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

// MemoryMemberRepository의 변수가 static이라 테스트가 정상적으로 되긴하지만
// 테스트 코드와 같은 인스턴스를 사용하기 위해 (의존성 주입)
    private final MemberRepository memberRepository;
    //MemberService를 스프링에 있는 MemberRepsotory와 연결시켜줌
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//
    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // ifPresent() : 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        // 위와 같은 코드
        // 로직이기 때문에 메서드로 만드는게 좋음.(Ctrl+Alt+M)
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> { // ifPresent() : 값이 있으면
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // ifPresent() : 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * ID를 통한 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
