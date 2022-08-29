package com.springAWS.web;

import com.springAWS.config.auth.dto.SessionUser;
import com.springAWS.service.posts.PostsService;
import com.springAWS.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController { //페이지에 관련된 컨트롤러

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
        //머스테치 스타터 덕에 컨트롤러에서 문자열 반환 시 앞의 경로와 뒤의 파일 확장자 자동 지정됨
        //src/main/resources/templates/index.mustache로 전환돼 View Resolver 처리하게 됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}
