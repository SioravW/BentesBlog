package com.example.BenteInIJsland.api.controllers;

import com.example.BenteInIJsland.api.model.BloggerNotFoundException;
import com.example.BenteInIJsland.api.model.FollowerNotFoundException;
import com.example.BenteInIJsland.db.model.Blogger;
import com.example.BenteInIJsland.db.model.Follower;
import com.example.BenteInIJsland.db.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/follower")
public class FollowerController {

    private FollowerRepository followerRepository;

    @Autowired
    public FollowerController(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Follower> getFollowers() {
        System.out.println("REEEEEEEEEEEEEEEE!");
        List<Follower> followers = followerRepository.findAll();
        return followers;
    }

    @GetMapping(path = " /{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Follower getFollower(@PathVariable("id") Integer id) {
        System.out.println(" BLAHHH!");
        return followerRepository.findById(id).orElseThrow(FollowerNotFoundException::new);
    }

    @GetMapping("/{id}/bloggers")
    public List<Blogger> getBloggersByFollowerId(@PathVariable("id") Integer id)  {
        Follower follower = followerRepository.findById(id).orElseThrow(FollowerNotFoundException::new);
        return follower.getBloggers();
    }
}
