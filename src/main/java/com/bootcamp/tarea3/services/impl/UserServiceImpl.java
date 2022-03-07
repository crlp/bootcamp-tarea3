package com.bootcamp.tarea3.services.impl;

import com.bootcamp.tarea3.core.exception.UseException;
import com.bootcamp.tarea3.entities.User;
import com.bootcamp.tarea3.repositories.UserRepository;
import com.bootcamp.tarea3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Mono<User> save(User user) {
        return this.userRepository.existsByLogin(user.getLogin())
                .flatMap(exists->
                        !exists ? this.userRepository.save(user): Mono.error(new UseException("Usuario exists"))
                );
    }

    @Override
    public Mono<User> findByUserAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password)
                .switchIfEmpty(Mono.error(new UseException("Login error")));
    }
}
