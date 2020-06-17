package com.example.BenteInIJsland.db.repository;

import com.example.BenteInIJsland.db.model.Follower;
import com.example.BenteInIJsland.db.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
