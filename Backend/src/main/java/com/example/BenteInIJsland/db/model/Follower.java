package com.example.BenteInIJsland.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties("bloggers")
public class Follower extends AbstractUser {

    public Follower() {
        super(null);
    }

    public Follower(String email) {
        super(email);
    }

    @Column
    @ManyToMany(mappedBy = "followers",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Blogger> bloggers;

    public List<Blogger> getBloggers() {
        return bloggers;
    }

    public void setBloggers(List<Blogger> bloggers) {
        this.bloggers = bloggers;
    }
}
