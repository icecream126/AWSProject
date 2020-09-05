package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    //Entity클래스와 거의 유사하지만 Dto를 따로 추가한 이유는 View Layer와 DB Layer의 분리를 위해서임
    //Entity 클래스는 데이터베이스와 연결된 코드이기 때문에 Request/Response 클래스로 사용해서는 안됨
    //Entity 클래스가 마구 변경되어서는 안되니까 대신에 Dto클래스가 화면전환 시 변경될 수 있도록 설정(View를 위한 DTO)
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
