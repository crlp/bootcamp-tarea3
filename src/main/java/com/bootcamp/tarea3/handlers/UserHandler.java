package com.bootcamp.tarea3.handlers;

import com.bootcamp.tarea3.entities.User;
import com.bootcamp.tarea3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(user -> this.userService.save(user))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class));
    }

    public Mono<ServerResponse> findByLoginAndPassword(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(user -> this.userService.findByUserAndPassword(user.getLogin(), user.getPassword()))
                .flatMap(blog -> ServerResponse.ok().body(Mono.just(blog), User.class))
                .switchIfEmpty(ServerResponse.badRequest().build());
    }
}
