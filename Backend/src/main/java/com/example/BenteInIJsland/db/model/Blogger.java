package com.example.BenteInIJsland.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties("followers")
public class Blogger extends AbstractUser {

    private String name;

    private String password;

    @OneToMany(fetch = FetchType.LAZY,
                mappedBy = "blogger",
                cascade = CascadeType.ALL)
    private List<Journey> journeys;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "blogger_follower",
                joinColumns = @JoinColumn(name = "blogger_id"),
                inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<Follower> followers;

    public Blogger() {
        super(null);
    }

    public Blogger(String email, String name, String password) {
        super(email);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }
}
