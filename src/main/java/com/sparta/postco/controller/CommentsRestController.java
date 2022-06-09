package com.sparta.postco.controller;

import com.sparta.postco.domain.*;
import com.sparta.postco.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentsRestController {
    private final CommentsRepository commentsRepository;
    private final CommentsService commentsService;

    @GetMapping("/api/comments/{post_id}")
    public List<Comments> readPost(@PathVariable Long post_id){
        return commentsRepository.findByPostIdOrderByCreatedAtDesc(post_id);
    }

    @PostMapping("/api/comments/{post_id}")
    public String createComments(@PathVariable Long post_id, @RequestBody CommentsRequestDTO requestDTO){
        if(requestDTO.getContents().isEmpty()){
            return "댓글 내용을 입력해주세요";
        }
        
        Comments comments = new Comments(requestDTO, post_id);
        commentsRepository.save(comments);
        return "댓글이 등록되었습니다.";
    }

    @PutMapping("/api/comments/{comments_id}")
    public String update(@PathVariable Long comments_id, @RequestBody CommentsRequestDTO requestDTO){
//        if(commentsRepository.findById(new Long(7)).isPresent()) {
//            System.out.println("있지요");
//            commentsService.update(comments_id, requestDTO);
//            return comments_id + "게시물이 수정 되었습니다.";
//        }
//        return "현재 게시물이 존재하지 않습니다.";
        if(requestDTO.getContents().isEmpty()){
            return "댓글 내용을 입력해주세요";
        }
        commentsService.update(comments_id, requestDTO);
        return "수정되었습니다.";
    }

    @DeleteMapping("/api/comments/{comments_id}")
    public Long deletePost(@PathVariable Long comments_id){
        commentsRepository.deleteById(comments_id);
        return comments_id;
    }
}
