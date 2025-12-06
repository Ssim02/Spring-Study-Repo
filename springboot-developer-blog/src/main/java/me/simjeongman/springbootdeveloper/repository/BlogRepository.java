package me.simjeongman.springbootdeveloper.repository;

import me.simjeongman.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> { // 상속받을 때 엔티티 Article과 엔티티의 PK타입 Long을 인수로 넣는다
}
