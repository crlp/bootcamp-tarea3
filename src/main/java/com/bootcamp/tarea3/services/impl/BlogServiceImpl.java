package com.bootcamp.tarea3.services.impl;

import com.bootcamp.tarea3.core.exception.NotFoundException;
import com.bootcamp.tarea3.core.exception.UseException;
import com.bootcamp.tarea3.core.exception.ValidationException;
import com.bootcamp.tarea3.entities.Author;
import com.bootcamp.tarea3.entities.Blog;
import com.bootcamp.tarea3.repositories.BlogRepository;
import com.bootcamp.tarea3.services.AuthorService;
import com.bootcamp.tarea3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorService authorService;


    @Override
    public Mono<Blog> findById(Long blogId) {
        return blogRepository.findById(blogId)
                .switchIfEmpty(Mono.error(new NotFoundException("blog.notFound")));
    }

    @Override
    public Mono<Blog> saveBlog(Blog request) {

        return authorService.getById(request.getAuthor().getId())
                .flatMap(author1 -> {
                    if(hasMore3Blogs(author1))
                        throw new ValidationException("Un usuario no puede tener mas de 3 Blogs");
                    if(!isOlderThan18(author1))
                        throw new ValidationException("Un usuario menor a 18 anos no puede tener blog");
                    return blogRepository.save(request);
                });
    }


    private boolean hasMore3Blogs(Author author){
        return blogRepository.countByAuthor(author) >= 3;
    }

    public boolean isOlderThan18(Author author){
        long diffInMillies = Math.abs(new Date().getTime() - author.getBirthDate().getTime());
        long diff = (diffInMillies / (1000l * 60 * 60 * 24 * 365));
        return diff > 18;
    }

}
