package com.bootcamp.tarea3.services;

import com.bootcamp.tarea3.entities.Author;
import reactor.core.publisher.Mono;

public interface AuthorService {
    Mono<Author> getById(String authorId);
    Mono<Author> save(Author author);
    Mono<Author> saveAuthorWithUser(Author author);
}
