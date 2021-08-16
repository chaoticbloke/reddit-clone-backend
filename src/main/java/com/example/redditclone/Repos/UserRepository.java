package com.example.redditclone.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditclone.models.Comment;
import com.example.redditclone.models.User;

@Repository
public interface UserRepository extends JpaRepository<Comment, Long> {

	void save(User user);

}
