package kr.printf.visitorbook.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
@Repository("articleDAO")
public class ArticleDAO extends AbstractDAO{
    public List<Map<String,Object>> selectArticleList(Map<String, Object> map) {
        return (List<Map<String,Object>>)selectList("article.selectArticleList", map);
    }
}
