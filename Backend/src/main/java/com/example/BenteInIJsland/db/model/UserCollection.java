package com.example.BenteInIJsland.db.model;

import java.util.List;

public class UserCollection {

    private static List<AbstractUser> users;

    public AbstractUser GetUserByEmail(String email){
        AbstractUser user = null;
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail() == email){
                user = users.get(i);
            }
        }
        return user;
    }

    public static AbstractUser getUserById(int id){
        AbstractUser user = null;
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == id){
                user = users.get(i);
            }
        }
        return user;
    }
}
