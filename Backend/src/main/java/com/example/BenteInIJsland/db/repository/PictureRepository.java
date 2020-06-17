package com.example.BenteInIJsland.db.repository;

import com.example.BenteInIJsland.db.model.Picture;
import com.example.BenteInIJsland.db.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Integer> {

}
