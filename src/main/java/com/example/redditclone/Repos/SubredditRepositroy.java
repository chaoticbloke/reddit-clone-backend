package com.example.redditclone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditclone.models.Subreddit;

@Repository
public interface SubredditRepositroy extends JpaRepository<Subreddit, Long> {

}
