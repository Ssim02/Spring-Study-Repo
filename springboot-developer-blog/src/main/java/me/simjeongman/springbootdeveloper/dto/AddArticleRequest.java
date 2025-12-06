package me.simjeongman.springbootdeveloper.dto;

// dto 패키지를 컨트롤러에서 요청한 본문을 받을 객체인 AddArticlerequest.java 파일
// DTO : 계층끼리 데이터를 교환하기 위해 사용하는 객체.(DAO와 달리, 단순하게 데이터를 옮기기 위해 사용하는 전달자 역할을 하는 객체이므로 별도의 비즈니스 로직 포함 x)

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.simjeongman.springbootdeveloper.domain.Article;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 생성자를 사용해 객체 생성. 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드이다.
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
