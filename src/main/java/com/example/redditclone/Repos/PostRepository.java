package com.example.redditclone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditclone.models.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
