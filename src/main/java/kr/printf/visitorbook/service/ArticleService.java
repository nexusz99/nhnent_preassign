package kr.printf.visitorbook.service;

import kr.printf.visitorbook.dto.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
public interface ArticleService {
    List<Article> selectArticleList(Map<String, Object> map) throws Exception;
}
