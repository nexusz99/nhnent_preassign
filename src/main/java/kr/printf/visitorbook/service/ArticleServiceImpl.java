package kr.printf.visitorbook.service;

import kr.printf.visitorbook.common.Tool;
import kr.printf.visitorbook.dao.ArticleDAO;
import kr.printf.visitorbook.dto.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
@Configuration
public class ArticleServiceImpl implements ArticleService{

    @Resource(name="articleDAO")
    private ArticleDAO articleDAO;

    @Bean(name="articleService")
    public ArticleServiceImpl articleServiceImpl() {
        return new ArticleServiceImpl();
    }

    public List<Article> selectArticleList(Map<String, Object> map) throws Exception {
        return articleDAO.selectArticleList(map);
    }

    public Article selectArticle(int idx) {
        return (Article) articleDAO.selectOne("kr.printf.visitorbook.dao.ArticleDAO.selectArticle", idx);
    }

    public int insertArticle(Article article) {
        int articleIdx = (Integer)articleDAO.insert("kr.printf.visitorbook.dao.ArticleDAO.insertArticle", article);
        return articleIdx;
    }

    public int updateArticle(Article article) {
        Article existed_article = (Article)articleDAO.selectOne("kr.printf.visitorbook.dao.ArticleDAO.internalselectArticle", article.getIdx());

        if(existed_article == null)
            return this.ARTICLE_NOT_FOUND;

        String hashed_passwd = Tool.generate_password_hash(article.getPasswd());
        if(hashed_passwd.compareTo(existed_article.getPasswd()) != 0)
            return this.WRONG_PASSWORD;

        articleDAO.update("kr.printf.visitorbook.dao.ArticleDAO.updateArticle", article);
        return 0;
    }
}
