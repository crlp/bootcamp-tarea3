package com.bootcamp.tarea3.services.impl;

import com.bootcamp.tarea3.core.exception.ValidationException;
import com.bootcamp.tarea3.entities.Post;
import com.bootcamp.tarea3.repositories.PostRepository;
import com.bootcamp.tarea3.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Mono<Post> save(Post post) {
        post.setDatePost(new Date());
        return this.postRepository.findByDatePost(new Date())
                .flatMap(postReturn -> {
                    if(postReturn!=null)
                        Mono.error(new ValidationException("Ya se registro un post hoy"));
                  return this.postRepository.save(post);
                });


    }

    @Override
    public Flux<Post> findAll() {
        return this.postRepository.findAll();
    }
}
