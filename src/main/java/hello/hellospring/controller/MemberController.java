package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // MemberController가 생성될 때 스프링이 가지고 있는 MemeberService(컨테이너에 등록시켜야함 @Service)를 자동으로 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
