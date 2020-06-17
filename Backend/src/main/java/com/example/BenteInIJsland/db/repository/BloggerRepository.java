package com.example.BenteInIJsland.db.repository;

import com.example.BenteInIJsland.db.model.Blogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Integer> {

    @Override
    List<Blogger> findAll();
}
