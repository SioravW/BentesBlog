package com.example.BenteInIJsland.api.controllers;

import com.example.BenteInIJsland.api.model.FollowerNotFoundException;
import com.example.BenteInIJsland.api.model.JourneyNotFoundException;
import com.example.BenteInIJsland.db.model.Follower;
import com.example.BenteInIJsland.db.model.Journey;
import com.example.BenteInIJsland.db.model.Post;
import com.example.BenteInIJsland.db.repository.FollowerRepository;
import com.example.BenteInIJsland.db.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
public class JourneyController {

    private JourneyRepository journeyRepository;

    @Autowired
    public JourneyController(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Journey getJourney(@PathVariable("id") Integer id) {
        return journeyRepository.findById(id).orElseThrow(JourneyNotFoundException::new);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPosts(@PathVariable("id")Integer id) {
        Journey journey = journeyRepository.findById(id).orElseThrow(JourneyNotFoundException::new);
        return journey.getPosts();
    }

//    @PostMapping("/")
//    public void createPost(@RequestParam("bloggerId") Integer bloggerId, @RequestParam("title") String title, @RequestParam("place") String place, @RequestParam("description") )
}
