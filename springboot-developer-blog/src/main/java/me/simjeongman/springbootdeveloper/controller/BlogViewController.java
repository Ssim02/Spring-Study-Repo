package me.simjeongman.springbootdeveloper.controller;

// /articles GET 요청을 처리할 코드

import lombok.RequiredArgsConstructor;
import me.simjeongman.springbootdeveloper.domain.Article;
import me.simjeongman.springbootdeveloper.dto.ArticleListViewResponse;
import me.simjeongman.springbootdeveloper.dto.ArticleViewResponse;
import me.simjeongman.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 블로그 글 리스트 저장. addArttribute()메서드를 이용해 모델에 값을 저장.

        return "articleList"; // articleList.html이라는 뷰 조회. 이 반환값은 resource/templates/articleList.html을 찾도록 뷰의 이름을 적은 것.
    }

    // getArticle()메서드는 인자 id에 URL로 넘어온 값을 받아 findByID()메서드로 넘겨 글을 조회하고,
    // 화면에서 사용할 모델에 데이터를 저장한 다음, 보여줄 화면의 템플릿 이름을 반환한다.
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    // 수정 화면을 보여주기 위한 newArticle() 메서드
    @GetMapping("/new-article")
    // id 키를 가진 쿼리 파라미터의 값을 id 변수에 매핑(id는 없을 수도 있음)
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // id가 없으면 생성
            // id가 없는 경우 기본 생성자를 이용해 빈 ArticleViewResponse 객체를 만든다
            model.addAttribute("article", new ArticleViewResponse());
        } else { // id가 있으면 수정
            // id가 있는 경우 기존 값을 가져오는 findById() 메서드를 호출한다.
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
