package com.bootcamp.tarea3.services;


import com.bootcamp.tarea3.entities.Blog;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BlogService {

    Mono<Blog> findById(Long blogId);
    Mono<Blog> saveBlog(Blog request);

}
