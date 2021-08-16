package com.example.redditclone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditclone.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
