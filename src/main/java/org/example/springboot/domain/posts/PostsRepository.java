package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //JpaRepository<Entity 클래스, PK타입> 기본적인 CRUD 메소드가 자동으로 생성됨
    //Entity클래스와 기본 Entity Repository는 함께 위치해야 함
}