package com.bootcamp.tarea3.repositories;

import com.bootcamp.tarea3.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Mono<User> findByLoginAndPassword(String login, String password);
    Mono<Boolean> existsByLogin(String login);

}
