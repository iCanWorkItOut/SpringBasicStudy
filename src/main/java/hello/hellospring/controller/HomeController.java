package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러가 정적파일(static : index.html)보다 우선순위가 높다.
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
