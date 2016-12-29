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

/**
 * Created by nexusz99 on 30/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ArticleControllerTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void test_1_list_all() throws Exception {
        List<Article> result = articleService.selectArticleList(null);
        Assert.assertEquals(1, result.size());
    }


}
