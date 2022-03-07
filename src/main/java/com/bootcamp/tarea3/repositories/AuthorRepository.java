package com.bootcamp.tarea3.repositories;

import com.bootcamp.tarea3.entities.Author;
import com.bootcamp.tarea3.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveMongoRepository<Author,String> {

}
