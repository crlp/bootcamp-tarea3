package com.bootcamp.tarea3.services;

import com.bootcamp.tarea3.entities.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> save(User user);
    Mono<User> findByUserAndPassword (String login, String password);
}
