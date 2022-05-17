package com.springAWS.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController { //페이지에 관련된 컨트롤러

    @GetMapping("/")
    public String index() {
        return "index";
        //머스테치 스타터 덕에 컨트롤러에서 문자열 반환 시 앞의 경로와 뒤의 파일 확장자 자동 지정됨
        //src/main/resources/templates/index.mustache로 전환돼 View Resolver 처리하게 됨
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
