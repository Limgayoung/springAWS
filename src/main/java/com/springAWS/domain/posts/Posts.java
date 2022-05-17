package com.springAWS.domain.posts;

import com.springAWS.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity { //실제 DB 테이블과 매칭될 클래스, 보통 Entity 클래스라고 함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙, GenerationType.IDENTITY 를 해야 auto_increment 됨
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼 //선언 안해도 해당 클래스의 필드는 모두 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
