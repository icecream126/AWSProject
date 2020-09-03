package org.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Controller를 JSON을 반환하는 컨트롤러로 바꿔줌
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        //Get의 요청을 받을 수 있는 API 만들어줌
        // 이제 /hello로 요청이 오면 문자열 hello를 반환하게 되는 기능을 갖게 됨
        return "hello";
    }
}
