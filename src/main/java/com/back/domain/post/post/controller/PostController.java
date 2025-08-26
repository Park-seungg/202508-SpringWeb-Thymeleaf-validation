package com.back.domain.post.post.controller;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/posts/write")
    @ResponseBody
    public String showWrite() {
        return """
                <form action="doWrite" target="_blank">
                  <input type="text" name="title" placeholder="제목" value="안녕">
                  <br>
                  <textarea name="content" placeholder="내용">반가워</textarea>
                  <br>
                  <input type="submit" value="작성">
                </form>
                """;
    }

    @GetMapping("/posts/dowrite")
    @ResponseBody
    @Transactional
    public String write(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String content) {
        if(title.isBlank()) return "제목을 입력해주세요.";
        if(content.isBlank()) return "내용을 입력해주세요.";

        Post post = postService.write(title, content);

        return "%d번 글이 작성되었습니다.".formatted(post.getId());
    }
}
