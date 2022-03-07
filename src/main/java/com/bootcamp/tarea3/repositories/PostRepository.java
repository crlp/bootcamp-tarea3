package com.bootcamp.tarea3.repositories;

import com.bootcamp.tarea3.entities.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
    Mono<Post> findByDatePost(Date date);
}
