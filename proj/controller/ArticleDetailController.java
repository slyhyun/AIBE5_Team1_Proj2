package proj.controller;

import java.util.Scanner;
import proj.entity.Article;
import proj.repository.ArticleRepository;
import proj.util.Rq;

public class ArticleDetailController {

    public void execute(Scanner sc, ArticleRepository articleRepository, Rq rq) {
        // 1. Rq에서 게시글 번호 꺼내기 (?id=3 이런 식으로 들어왔다고 가정)
        int id = rq.getId();

        // 2. 번호를 안 넣은 경우
        if (id == 0) {
            System.out.println("상세보기 할 게시글 번호를 입력해주세요.");
            return;
        }

        // 3. Repository에서 해당 ID의 게시글 찾기
        Article article = articleRepository.findById(id);

        // 4. 게시글이 없는 경우
        if (article == null) {
            System.out.println(id + "번 게시글은 존재하지 않습니다.");
            return;
        }

        // 5. 게시글이 존재하면 상세 정보 출력
        System.out.println("== 게시글 상세보기 ==");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("등록일 : " + article.getRegDate());
        System.out.println("내용 --------------------");
        System.out.println(article.getContent());
        System.out.println("-------------------------");

        // 필요하다면 뒤로 가기 등의 안내 문구 추가
        System.out.println("엔터를 누르면 목록으로 돌아갑니다.");
        sc.nextLine();
    }
}
