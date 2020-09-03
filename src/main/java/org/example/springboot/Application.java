package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //스프링부트에서는 내장 WAS를 실행하는것을 권장하고 있다함(외부 Server 사용 시 작업량 증가)
        SpringApplication.run(Application.class, args);//내장 WAS(Web Application Server) 실행
    }
}
