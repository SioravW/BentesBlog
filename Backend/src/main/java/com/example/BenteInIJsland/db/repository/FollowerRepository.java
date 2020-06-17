package com.example.BenteInIJsland.db.repository;

import com.example.BenteInIJsland.db.model.Blogger;
import com.example.BenteInIJsland.db.model.Follower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Integer> {

    @Override
    List<Follower> findAll();
}
