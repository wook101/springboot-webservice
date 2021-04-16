package com.wook.webservice.controller;

import com.wook.webservice.domain.posts.PostsRepository;
import com.wook.webservice.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private PostsRepository postsRepository;

    public HomeController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }


    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
