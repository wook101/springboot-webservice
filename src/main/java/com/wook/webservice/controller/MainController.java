package com.wook.webservice.controller;

import com.wook.webservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    final private PostsService postsService;

    public MainController(PostsService postsService){
        this.postsService = postsService;
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

}
