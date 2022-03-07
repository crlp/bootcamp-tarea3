package com.bootcamp.tarea3.handlers;

import com.bootcamp.tarea3.entities.Author;
import com.bootcamp.tarea3.entities.User;
import com.bootcamp.tarea3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AuthorHandler {

    @Autowired
    private AuthorService authorService;


    public Mono<ServerResponse> saveAuthorWithUser(ServerRequest request){
        return request.bodyToMono(Author.class)
                .flatMap(author -> this.authorService.saveAuthorWithUser(author))
                .flatMap(a-> ServerResponse.ok().body(Mono.just(a), Author.class))
                .switchIfEmpty(ServerResponse.badRequest().build());

    }
    public Mono<ServerResponse> save(ServerRequest request){
        return request.bodyToMono(Author.class)
                .flatMap(author -> this.authorService.save(author))
                .flatMap(a-> ServerResponse.ok().body(Mono.just(a), Author.class))
                .switchIfEmpty(ServerResponse.badRequest().build());

    }
}
