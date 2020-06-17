package com.example.BenteInIJsland.db.repository;

import com.example.BenteInIJsland.db.model.Blogger;
import com.example.BenteInIJsland.db.model.Follower;
import com.example.BenteInIJsland.db.model.Journey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JourneyRepository extends CrudRepository<Journey, Integer> {

    List<Journey> findAllByBlogger(Blogger blogger);
}
