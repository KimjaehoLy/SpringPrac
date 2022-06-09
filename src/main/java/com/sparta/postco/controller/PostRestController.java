package com.sparta.postco.controller;

import com.sparta.postco.domain.Post;
import com.sparta.postco.domain.PostRepository;
import com.sparta.postco.domain.PostRequestDTO;
import com.sparta.postco.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostRestController {
    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post> readPosts(){return postRepository.findAllByOrderByCreatedAtDesc();}

    @GetMapping("/api/post/{id}")
    public Optional<Post> readPost(@PathVariable Long id){
        return postRepository.findById(id);
    }

    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDTO requestDTO){
        Post post = new Post(requestDTO);
        return postRepository.save(post);
    }

    @PutMapping("/api/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO){
        postService.update(id, requestDTO);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }
}
