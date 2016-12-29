package kr.printf.visitorbook.controllers;

import kr.printf.visitorbook.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 28/12/2016.
 */
@Controller
public class article {

    @Resource(name="articleService")
    private ArticleService articleService;

    @RequestMapping(value="/articles",method= RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Map<String, Object>>> listArticle() throws Exception {
        List<Map<String, Object>> maps = articleService.selectArticleList(null);
        return new ResponseEntity<List<Map<String, Object>>>(maps, HttpStatus.OK);
    }

}
