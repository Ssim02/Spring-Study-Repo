package me.simjeongman.springbootdeveloper.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.simjeongman.springbootdeveloper.domain.Article;
import me.simjeongman.springbootdeveloper.dto.AddArticleRequest;
import me.simjeongman.springbootdeveloper.dto.UpdateArticleRequest;
import me.simjeongman.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에 저장되어 있는 글을 모두 가져오는 findAll()메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 글 하나를 조회는 API를 구현
    // 이 메서드는 데이터베이스 저장되어 있는 글의 ID를 이용해 글을 조회
    // JPA에서 제공하는 findById()메서드를 사용해 ID를 받아 엔티티를 조회하고 없으면 IllegalArgumentException 예외를 발생시킨다
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // ID에 해당하는 블로그 글을 삭제하는 API를 구현
    // delete() 메서드 : 블로그 글의 ID를 받은 뒤 JPA에서 제공하는 deletedById()메서드를 이용해 데이터베이스에서 데이터를 삭제.
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 글을 수정하는 API를 구현
    // update() 메서드 : 글을 수정한다.
    @Transactional // 트랜젝션 메서드
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
