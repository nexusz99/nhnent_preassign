package kr.printf.visitorbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * zCreated by nexusz99 on 27/12/2016.
 */
@Controller
public class index {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello world";
    }
}
