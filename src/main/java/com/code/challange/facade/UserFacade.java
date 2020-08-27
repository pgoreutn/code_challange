package com.code.challange.facade;

import com.code.challange.ModelMapperUtils;
import com.code.challange.dto.UserDto;
import com.code.challange.model.User;
import com.code.challange.repository.UserRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserFacade {

    private final UserRepository userRepository;

    @Inject
    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Uni<User> create(UserDto dto){

        Optional<User> user  = ModelMapperUtils.map(dto, User.class);
        user.get().setId(UUID.randomUUID().toString());

        return  userRepository.add(user.orElseThrow());
    }


    public Uni<Collection<User>> getAll(){

        return  userRepository.getALl();
    }

    public void delete(String id) {
        userRepository.delete(id);
    }
}
