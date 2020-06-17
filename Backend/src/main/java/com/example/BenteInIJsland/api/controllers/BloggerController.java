package com.example.BenteInIJsland.api.controllers;

import com.example.BenteInIJsland.api.model.BloggerNotFoundException;
import com.example.BenteInIJsland.db.model.Blogger;
import com.example.BenteInIJsland.db.model.Follower;
import com.example.BenteInIJsland.db.model.Journey;
import com.example.BenteInIJsland.db.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogger")
public class BloggerController {

    private BloggerRepository bloggerRepository;

    @Autowired
    public BloggerController(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Blogger> getAllBloggers() {
        System.out.println("GETALLBLOGGER");
        return bloggerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Blogger getBloggerById(@PathVariable("id") Integer id) {
        return bloggerRepository.findById(id).orElseThrow(BloggerNotFoundException::new);
    }

    @GetMapping("/{id}/followers")
    public List<Follower> getFollowersByBloggerId(@PathVariable("id") Integer id)  {
        Blogger blogger = bloggerRepository.findById(id).orElseThrow(BloggerNotFoundException::new);
        return blogger.getFollowers();
    }

    @GetMapping("/{id}/journeys")
    public List<Journey> getJoutneysByBloggerId(@PathVariable("id") Integer id) {
        Blogger blogger = bloggerRepository.findById(id).orElseThrow(BloggerNotFoundException::new);
        return blogger.getJourneys();
    }
}
