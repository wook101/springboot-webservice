package com.wook.webservice.service;

import com.wook.webservice.domain.posts.Posts;
import com.wook.webservice.domain.posts.PostsRepository;
import com.wook.webservice.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Runner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void dto데이터_Post테이블에저장(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("제목 테스트")
                .content("본문 테스트")
                .author("ehddnr1022@gmail.com")
                .build();

        //when
        postsService.save(dto);

        //that
        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("제목 테스트");
        assertThat(posts.getContent()).isEqualTo("본문 테스트");
        assertThat(posts.getAuthor()).isEqualTo("ehddnr1022@gmail.com");


    }


}
