package com.sparta.postco.service;

import com.sparta.postco.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    @Transactional
    public Long update(Long id, CommentsRequestDTO requestDTO){
        Comments comments = commentsRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        comments.update(requestDTO);
        return id;
    }
}
