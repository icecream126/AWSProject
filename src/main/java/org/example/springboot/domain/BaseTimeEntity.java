package org.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //BaseEntity 상속 시 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 포함
public abstract class BaseTimeEntity {
    //모든 Entity의 상위클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할
    @CreatedDate //Entity가 생성되어 저장될때 시간이 자동 저장됨
    private LocalDateTime createDate;

    @LastModifiedDate private LocalDateTime modifiedDate; //조회한 Entity의 값을 변경할 때 시간이 자동저장됨
}
