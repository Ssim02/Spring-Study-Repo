package me.simjeongman.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// 이 인터페이스는 DB에서 데이터를 가져오는 퍼시스턴트 계층 역할을 할 것이다.
// member라는 이름의 테이블에 접근해서 Member클래스에 매핑하는 구현체이다.
// 리포지터리는 엔티티에 있는 데이터들을 조회하거나 저장, 변경, 삭제를 할 때 사용하는 인터페이스.
// 스프링 데이터 JPA에서 제공하는 인터페이스인 JpaRepository 클래스를 상속받아 간단하게 구현 가능.
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
}
