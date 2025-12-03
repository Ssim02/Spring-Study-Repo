package me.simjeongman.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// 이 인터페이스는 DB에서 데이터를 가져오는 퍼시스턴트 계층 역할을 할 것이다.
// member라는 이름의 테이블에 접근해서 Member클래스에 매핑하는 구현체이다.
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
