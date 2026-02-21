package proj.controller;

import proj.entity.Article;
import proj.repository.ArticleRepository;
import java.util.List;
import java.util.Scanner;

public class ArticleListController {
    public void execute(Scanner sc, ArticleRepository articleRepository) {
        List<Article> articles = articleRepository.findAll();

        if (articles.size() == 0) {
            System.out.println("현재 등록된 게시글이 없습니다.");
        } else {
            System.out.println("번호 | 제목 | 등록일");
            System.out.println("-------------------");

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                System.out.println(article.getId() + " | " + article.getTitle() + " | " + article.getRegDate());
            }
        }
    }
}


