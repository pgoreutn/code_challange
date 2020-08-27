package com.code.challange.repository;

import com.code.challange.db.UserDB;
import com.code.challange.model.User;
import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;

@ApplicationScoped
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public Uni<User> add(User entity) {
        logger.info("Try to persist new sucursal");

        return UserDB.getInstance().add(entity);
    }


    public Uni<Collection<User>> getALl() {
        logger.info("Try to get All  users");

        return UserDB.getInstance().getAll();
    }

    public void delete(String id) {
        UserDB.getInstance().delete(id);
    }
}
