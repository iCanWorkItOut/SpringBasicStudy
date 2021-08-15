package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
/*  생성자 주입을 통한 DI : 의존관계가 실행중에 동적으로 변하는 경우는 없으므로(immutable) 생성자 주입을 권장
    + 순환 참조 방지, 테스트 코드 작성 편리(단순 POJO를 이용한 테스트 코드 가능)
    */
    private final MemberService memberService;

    @Autowired // MemberController가 생성될 때 스프링이 가지고 있는 MemeberService(컨테이너에 등록시켜야함 @Service)를 자동으로 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

/*  필드 주입을 통한 DI : 여러 컴포넌트 간에 순환 참조가 발생할 수 있음
    @Autowired
    private MemberService memberService;*/

/*  Setter 주입을 통한 DI : 처음 셋팅(스프링 조립)이 되고 나면 바뀔 일이 없는데 public setter를 통해 바뀔 가능성이 있음
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/
}
