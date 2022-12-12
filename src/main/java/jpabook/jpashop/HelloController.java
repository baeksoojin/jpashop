package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // localhost:8080/hello로 매핑
    public String hello(Model model){
        model.addAttribute("data","hello!!!"); //data를 view에 넘김
        return "hello"; //templates/hello에 연결. -> springboot의 thymeleaf가 resource:templates/*.html로 매핑함.
    }
}
