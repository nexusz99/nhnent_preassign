package kr.printf.visitorbook.dao;

import kr.printf.visitorbook.dto.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
@Repository("articleDAO")
public class ArticleDAO extends AbstractDAO{
    public List<Article> selectArticleList(Map<String, Object> map) {
        return (List<Article>)selectList("kr.printf.visitorbook.dao.ArticleDAO.selectArticleList", map);
    }
}
