package kr.printf.visitorbook.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.printf.visitorbook.common.EmailValidator;
import kr.printf.visitorbook.common.Tool;
import kr.printf.visitorbook.dto.Article;
import kr.printf.visitorbook.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 28/12/2016.
 */
@Controller
public class article {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="/articles",method= RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Article>> listArticle() throws Exception {
        List<Article> maps = articleService.selectArticleList(null);
        return new ResponseEntity<List<Article>>(maps, HttpStatus.OK);
    }

    @RequestMapping(value="/articles/{article_id}", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<Article> getArticle(@PathVariable("article_id") int article_id) {
        Article article = articleService.selectArticle(article_id);
        if(article == null) {
            return new ResponseEntity<Article>(article, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

    @RequestMapping(value="/articles", method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> insertArticle(@RequestBody String body) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(body);
        } catch (IOException e) {
            return new ResponseEntity<String>("Wrong Request", HttpStatus.BAD_REQUEST);
        }
        String content = node.get("content").asText();
        String email = node.get("email").asText();
        String passwd = Tool.generate_password_hash(node.get("passwd").asText());

        if(content == null || email == null || passwd == null )
        {
            return new ResponseEntity<String>("Missing Parameters", HttpStatus.BAD_REQUEST);
        }

        if(!EmailValidator.validate(email)) {
            return new ResponseEntity<String>("Email not validate", HttpStatus.BAD_REQUEST);
        }

        Article article = new Article();
        article.setContent(content);
        article.setEmail(email);
        article.setPasswd(passwd);
        articleService.insertArticle(article);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
