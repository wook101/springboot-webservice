package com.wook.webservice.service;

import com.wook.webservice.domain.posts.PostsRepository;
import com.wook.webservice.dto.PostsMainResponseDto;
import com.wook.webservice.dto.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
