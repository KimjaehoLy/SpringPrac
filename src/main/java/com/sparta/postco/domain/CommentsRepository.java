package com.sparta.postco.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
//    List<Comments> findAllByOrderByLocalDateTimeAtDesc();
    List<Comments> findByPostIdOrderByCreatedAtDesc(Long PostId);

}
