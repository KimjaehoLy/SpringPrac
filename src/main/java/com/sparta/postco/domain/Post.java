package com.sparta.postco.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contents;

    public Post(String title, String name, String contents){
        this.title = title;
        this.name = name;
        this.contents = contents;
    }
    public Post(PostRequestDTO postRequestDTO){
        this.contents = postRequestDTO.getContents();
        this.title = postRequestDTO.getTitle();
        this.name = postRequestDTO.getName();
    }

    public void update(PostRequestDTO requestDTO){
        this.contents = requestDTO.getContents();
        this.title = requestDTO.getTitle();
        this.name = requestDTO.getName();
    }

}
