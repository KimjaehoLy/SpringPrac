package com.sparta.postco.service;

import com.sparta.postco.domain.Post;
import com.sparta.postco.domain.PostRepository;
import com.sparta.postco.domain.PostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDTO requestDTO){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDTO);
        return id;
    }
}
