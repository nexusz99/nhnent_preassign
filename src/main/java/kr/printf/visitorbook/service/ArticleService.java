package kr.printf.visitorbook.service;

import java.util.List;
import java.util.Map;

/**
 * Created by nexusz99 on 29/12/2016.
 */
public interface ArticleService {
    List<Map<String, Object>> selectArticleList(Map<String, Object> map) throws Exception;
}
