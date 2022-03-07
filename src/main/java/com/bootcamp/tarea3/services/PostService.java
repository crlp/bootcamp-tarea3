package com.bootcamp.tarea3.services;

import com.bootcamp.tarea3.entities.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Mono<Post> save(Post post);
    Flux<Post> findAll();
}
