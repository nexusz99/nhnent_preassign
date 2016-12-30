package kr.printf.visitorbook.service;

import kr.printf.visitorbook.dto.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
public interface ArticleService {
    /* ERROR Code */
    public static int ARTICLE_NOT_FOUND = 1;
    public static int WRONG_PASSWORD = 2;

    List<Article> selectArticleList(Map<String, Object> map) throws Exception;
    Article selectArticle(int idx);
    int insertArticle(Article article);
    int updateArticle(Article article);
}
