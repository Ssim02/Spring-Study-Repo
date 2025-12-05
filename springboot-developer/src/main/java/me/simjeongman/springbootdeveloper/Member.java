package me.simjeongman.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

// 퍼시스턴트 계층 코드
// DB에 접근할 때 사용할 객체인 Member DAO를 생성하고 실제 DB에 접근하는 코드를 작성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity // 엔티티로 지정
public class Member {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가하도록. @GeneratedValue는 기본키의 생성 방식을 결정한다.
    @Column(name = "id", updatable = false)
    private Long id; // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false) // name이라는 not null 컬럼과 매핑
    private String name; // DB 테이블의 'name' 컬럼과 매칭

    public void changeName(String name) {
        this.name = name;
    }
}
