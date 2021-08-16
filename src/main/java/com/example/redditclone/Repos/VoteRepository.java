package com.example.redditclone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditclone.models.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
