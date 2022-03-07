package com.bootcamp.tarea3.services.impl;

import com.bootcamp.tarea3.core.exception.UseException;
import com.bootcamp.tarea3.entities.Author;
import com.bootcamp.tarea3.repositories.AuthorRepository;
import com.bootcamp.tarea3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Mono<Author> getById(String authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public Mono<Author> save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Mono<Author> saveAuthorWithUser(Author author) {
        return authorRepository.findById(author.getId())
                .flatMap(authorDB ->
                        authorDB.getUser() == null ?
                                authorRepository.save(author) :
                                Mono.error(new UseException("Author tiene un usuario asignado")));
    }


}
