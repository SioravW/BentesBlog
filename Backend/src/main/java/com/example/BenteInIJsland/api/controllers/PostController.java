package com.example.BenteInIJsland.api.controllers;

import com.example.BenteInIJsland.api.model.JourneyNotFoundException;
import com.example.BenteInIJsland.api.model.PostNotFoundException;
import com.example.BenteInIJsland.db.model.Journey;
import com.example.BenteInIJsland.db.model.Picture;
import com.example.BenteInIJsland.db.model.Post;
import com.example.BenteInIJsland.db.repository.JourneyRepository;
import com.example.BenteInIJsland.db.repository.PictureRepository;
import com.example.BenteInIJsland.db.repository.PostRepository;
import com.example.BenteInIJsland.filestorage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostRepository postRepository;
    private FileStorageService fileStorageService;
    private PictureRepository pictureRepository;

    @Autowired
    public PostController(PostRepository postRepository, FileStorageService fileStorageService, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.fileStorageService = fileStorageService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPost(@PathVariable("id") Integer id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

//    @GetMapping("/{id}/picturesOld")
//    public List<Picture> getPictures(@PathVariable("id") Integer id) {
//        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
//        return post.getPictures();
//    }

    @GetMapping("/{id}/pictures")
    public List<String> getPictures(@PathVariable("id") Integer id, UriComponentsBuilder uriBuilder) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        String basePath = uriBuilder
                .pathSegment("picture")
                .build()
                .toString();
        return post.getPictures().stream()
                .map(picture -> basePath + "/" +picture.getUrl())
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/picture")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadFile(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        fileStorageService.storeFile(file);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Picture picture = new Picture();
        picture.setUrl(fileName);
        picture.setPost(postRepository.findById(id).orElseThrow(PostNotFoundException::new));
        pictureRepository.save(picture);
    }
}
