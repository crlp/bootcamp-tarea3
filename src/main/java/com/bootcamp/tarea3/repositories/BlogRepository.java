package com.bootcamp.tarea3.repositories;


import com.bootcamp.tarea3.entities.Author;
import com.bootcamp.tarea3.entities.Blog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BlogRepository extends ReactiveMongoRepository<Blog, Long> {
    int countByAuthor(Author author);
}
