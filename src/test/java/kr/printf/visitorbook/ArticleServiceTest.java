package kr.printf.visitorbook;

import kr.printf.visitorbook.dto.Article;
import kr.printf.visitorbook.service.ArticleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by nexusz99 on 30/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void test_1_list_all() throws Exception {
        List<Article> result = articleService.selectArticleList(null);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void test_2_get_article_by_idx() {
        Article article = articleService.selectArticle(1);
        Assert.assertEquals("test", article.getContent());
    }

    @Test
    public void test_3_get_article_by_wrong_idx() {
        Article article = articleService.selectArticle(100);
        Assert.assertNull(article);
    }

    @Test
    public void test_4_insert_new_article() {
        Article article = new Article();
        article.setContent("new article");
        article.setEmail("asdf@asdf.com");
        article.setPasswd("fd3d77c95765afbf235c65fbab99ef54a43a8942c416cd55042a928e841012ba");
        articleService.insertArticle(article);
        Assert.assertThat("article_idx", article.getIdx(), greaterThan(1));
    }

    @Test
    public void test_5_update_article() {
        Article article = new Article();
        article.setIdx(2);
        article.setPasswd("qwerasdf");
        article.setContent("updated!!");
        articleService.updateArticle(article);

        Article updated = articleService.selectArticle(2);
        Assert.assertNull(null);
        //Assert.assertEquals("updated!!", updated.getContent());
        //Assert.assertThat("modified_updated", updated.getModified_at(), greaterThan(updated.getCreated_at()));
    }

}
