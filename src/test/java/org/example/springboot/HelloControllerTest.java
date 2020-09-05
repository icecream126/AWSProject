package org.example.springboot;

import org.example.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //SpringRunner이라는 실행자 사용
@WebMvcTest(controllers= HelloController.class) //Web에 집중할 수 있는 annotation
public class HelloControllerTest {
    @Autowired //Bean 주입
    private MockMvc mvc;//mvc테스트의 시작점
    //이 클래스를 이용해서 HTTP GET, POS 등에 대한 API테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
        //perform(get"/hello") : /hello 주소로 HTTP GET요청 진행
        //.andExpect(status.isOk) : Status 검증. 200, 404, 500 등의 상태 검증. OK==200
        //.andExpect(content.string("hello") : Controller에서 hello를 잘 리턴했는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}
