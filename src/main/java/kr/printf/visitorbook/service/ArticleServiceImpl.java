package kr.printf.visitorbook.service;

import kr.printf.visitorbook.dao.ArticleDAO;
import kr.printf.visitorbook.dto.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

    @Resource(name="articleDAO")
    private ArticleDAO articleDAO;

    public List<Article> selectArticleList(Map<String, Object> map) throws Exception {
        return articleDAO.selectArticleList(map);
    }
}
