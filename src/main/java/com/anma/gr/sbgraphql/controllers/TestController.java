package com.anma.gr.sbgraphql.controllers;

import com.anma.gr.sbgraphql.model.Author;
import com.anma.gr.sbgraphql.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @QueryMapping
    public Author author(@Argument Integer id) {
        return new Author(id, "some author");
    }

    @QueryMapping
    public Book book(@Argument Integer id) {
        return new Book("some title");
    }

//    @SchemaMapping
//    public Author getAuthor(@Argument Long id) {
//        return new Author(1L, "Tolkien");
//    }
}
