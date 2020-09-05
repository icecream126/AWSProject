package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

//Entity 클래스에는 절대 Setter 함부로 안 만듬(특수한 목적이 있을 때만 Setter가 아닌 특수목적함수로 만들어줌)
@Getter //lombok (모든 필드 Getter 메소드 생성)
@NoArgsConstructor //lombok (생성자 자동추가)
@Entity //JPA (테이블과 링크될 클래스임을 나타냄)
public class Posts extends BaseTimeEntity {
    //실제 DB 테이블과 매칭될 클래스. 보통 Entity 클래스라고도 함.
    //JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업

    @Id //해당 테이블의 PK(Primary Key) 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙(auto_increment가능)
    private Long id;

    @Column(length = 500, nullable =false) //테이블의 column을 나타냄. 굳이 안써도 해당 클래스의 필드는 모두 칼럼이 됨
    private String title;

    //Column을 굳이 사용한 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성(생성자 상단에 표시하면 생성자에 포함된 필드만 빌더에 포함)
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
