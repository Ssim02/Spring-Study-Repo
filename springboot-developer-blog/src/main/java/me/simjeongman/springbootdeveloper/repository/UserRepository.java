package me.simjeongman.springbootdeveloper.repository;

import me.simjeongman.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*  User 엔티티에 대한 리포지터리  */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email로 사용자 정보를 가져옴
}
