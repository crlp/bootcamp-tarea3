package com.bootcamp.tarea3.routes;

import com.bootcamp.tarea3.handlers.AuthorHandler;
import com.bootcamp.tarea3.handlers.PostHandler;
import com.bootcamp.tarea3.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {

  /*  @Bean
    public RouterFunction<ServerResponse> blogRoutes(BlogHandler blogHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/blogs"),
                RouterFunctions
                        .route(GET(""), blogHandler::findAll)
                        .andRoute(GET("/{id}"), blogHandler::findById)
                        .andRoute(POST("").and(contentType(APPLICATION_JSON)), blogHandler::save)
//						.andRoute(PUT("/{id}").and(contentType(APPLICATION_JSON)), blogHandler::update)
                        .andRoute(DELETE("/{id}"), blogHandler::delete)
            );
    }

    @Bean
    public RouterFunction<ServerResponse> authorRoutes(AuthorHandler authorHandler){
        return RouterFunctions.nest(RequestPredicates.path("/authors"),
                RouterFunctions
                .route(GET(""), authorHandler::findAll)
                .andRoute(GET("/by-email/{email}"), authorHandler::findByEmail)
                .andRoute(GET("/query"), authorHandler::findByEmail)
//                .andRoute(GET("/query/{email}"), authorHandler::findByEmail)
                .andRoute(GET("/{id}"), authorHandler::findById)
                .andRoute(POST("").and(accept(APPLICATION_JSON)),authorHandler::save)
                .andRoute(DELETE("/{id}"), authorHandler::delete)
            );
    }

    @Bean
    public RouterFunction<ServerResponse> postRoutes(PostHandler postHandler){
        return RouterFunctions.nest(RequestPredicates.path("/posts"),
                RouterFunctions.route(GET(""), postHandler::findAll)
                .andRoute(POST("").and(accept(APPLICATION_JSON)),postHandler::save)
                );
    }*/

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
        return RouterFunctions.nest(RequestPredicates.path("/users"),
                RouterFunctions.route(POST("/login"), userHandler::findByLoginAndPassword)
                        .andRoute(POST("").and(accept(APPLICATION_JSON)), userHandler::save)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> authorRoutes(AuthorHandler authorHandler){
        return RouterFunctions.nest(RequestPredicates.path("/authors"),
                RouterFunctions.route(POST("/user"), authorHandler::saveAuthorWithUser)
                        .andRoute(POST("").and(accept(APPLICATION_JSON)), authorHandler::save));
    }

    @Bean
    public RouterFunction<ServerResponse> postRoutes(PostHandler postHandler){
        return RouterFunctions.nest(RequestPredicates.path("/posts"),
                RouterFunctions.route(GET(""), postHandler::findAll)
                        .andRoute(POST("").and(accept(APPLICATION_JSON)),postHandler::save)
        );
    }

}
