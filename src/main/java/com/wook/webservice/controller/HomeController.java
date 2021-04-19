package com.wook.webservice.controller;

import com.wook.webservice.domain.posts.PostsRepository;
import com.wook.webservice.dto.PostsSaveRequestDto;
import com.wook.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    final private PostsService postsService;

    public HomeController(PostsService postsService){
        this.postsService = postsService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

}
