package me.simjeongman.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    <이 코드가 하는 일>
    1. DB에 refresh_token 테이블을 만든다.
    2. 유저 ID와 토큰 값을 저장한다.
    3. 유저 한명당 딱 하나의 토큰만 가지도록 강제한다.(unique 속성)
    4. 토큰 값이 변경될 때(update) 사용할 기능을 제공한다.
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 만들어주는데, 접근 권한을 protected로 막아둔다
@Getter // lombok 기능
@Entity // JPA가 관리하는 객체임을 선언. 이 클래스는 자동으로 데이터베이스의 테이블과 매핑됨.
public class RefreshToken {

    // 필드(데이터베이스 컬럼)
    @Id // 이 필드가 테이블의 PK임
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK값을 직접 넣지 않고, 1씩 자동 증가시킨다.
    @Column(name = "id", updatable = false) // 한 번 저장된 ID는 수정이 불가능하게 막는다
    private Long id;

    // "user_id": 리프레시 토큰의 주인(유저)의 ID를 저장
    // nullable = false: 유저 ID없이 토큰만 존재할 수는 없다(필수값)
    // unique = true: 한 유저는 하나의 리프레시 토큰만 가질 수 있다는 제약조건이다.
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken; // 실제 토큰 문자열 값이 저장되는 곳

    // 위에서 기본 생성자를 protected로 막았기 때문에, 이 객체를 생성하려면 반드시 이 생성자를 써야 함.
    public RefreshToken(Long userId, String refreshToken) { // 생성자
        this.userId = userId;
        this.refreshToken = refreshToken;
    }

    // 비즈니스 로직(수정 메서드)
    // 토큰 업데이트 기능
    // 재발급 요청이 오면 기존 객체의 refreshToken 내용만 새 것으로 갈아끼우는 역할을 한다.
    public RefreshToken update(String newRefreshToken) {
        this.refreshToken = newRefreshToken;
        return this;
    }
}
