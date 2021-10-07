package com.anma.gr.sbgraphql.controllers;

import com.anma.gr.sbgraphql.model.Author;
import com.anma.gr.sbgraphql.model.Book;
import com.anma.gr.sbgraphql.repo.BookRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TestController {

    private final BookRepo bookRepo;

    public TestController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @QueryMapping
    public Author author(@Argument Integer id) {
        return new Author(id, "some author");
    }

    @QueryMapping
    public Book book(@Argument Integer id) throws FileNotFoundException {
        return bookRepo.findById(id).orElseThrow(() -> new FileNotFoundException("Not found"));
    }

    @QueryMapping
    public List<Book> books(@Argument Integer count) {
        return bookRepo.findAll().stream().filter(book -> book.getId() <= count).collect(Collectors.toList());
    }

//    @SchemaMapping
//    public Author getAuthor(@Argument Long id) {
//        return new Author(1L, "Tolkien");
//    }
}
