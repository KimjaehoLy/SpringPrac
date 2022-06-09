package com.sparta.postco.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Comments extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private Long postId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contents;

    public Comments(String name, String contents){
        this.name = name;
        this.contents = contents;
    }

    public Comments(CommentsRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.contents = requestDTO.getContents();
    }
    public Comments(CommentsRequestDTO requestDTO, Long postId){
        this.name = requestDTO.getName();
        this.contents = requestDTO.getContents();
        this.postId = postId;
    }

    public void update(CommentsRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.contents = requestDTO.getContents();
    }
}
