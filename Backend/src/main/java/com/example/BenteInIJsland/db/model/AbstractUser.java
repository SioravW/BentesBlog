package com.example.BenteInIJsland.db.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    public AbstractUser(String email){
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }
}
