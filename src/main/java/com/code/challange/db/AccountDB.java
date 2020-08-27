package com.code.challange.db;

import com.code.challange.model.Account;
import io.netty.util.internal.StringUtil;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class AccountDB {

    private static HashMap<String,Account> map = new HashMap<>();

    public Account add(Account entity){
        if(StringUtil.isNullOrEmpty(entity.getUser())){
            throw new RuntimeException("The user id should be present");
        }
        map.put(entity.getId() , entity);
        return entity;
    }

    public Optional<Account> findById(String id){
        return Optional.ofNullable(map.get(id));
    }

    public Optional<List<Account>> getAll(){
        return Optional.ofNullable(map.values().stream().collect(Collectors.toList()));
    }

    public void delete(String id) {
        map.remove(id);
    }
}