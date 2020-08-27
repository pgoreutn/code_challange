package com.code.challange.db;

import com.code.challange.model.User;
import io.smallrye.mutiny.Uni;

import java.util.Collection;
import java.util.HashMap;

public class UserDB {

    private static UserDB instance ;

    private static HashMap<String,User> map;

    private UserDB() {
    }

    public static UserDB getInstance(){
        if(instance==null){
            instance = new UserDB();
            map = new HashMap<>();
        }
        return instance;
    }

    public Uni<User> add(User user){
        map.put(user.getEmail() , user);
        return Uni.createFrom().item(user);
    }



    public Uni<Collection<User>>  getAll(){
        return Uni.createFrom().item(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }
}
