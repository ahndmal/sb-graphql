package com.anma.gr.sbgraphql.controllers;

import com.anma.gr.sbgraphql.model.Author;
import com.anma.gr.sbgraphql.model.Book;
import com.anma.gr.sbgraphql.model.BooksResponse;
import com.anma.gr.sbgraphql.repo.BookRepo;
import com.anma.gr.sbgraphql.services.GBooksService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "*")
public class BooksController {

    private final BookRepo bookRepo;
    private final GBooksService gBooksService;

    public BooksController(BookRepo bookRepo, GBooksService gBooksService) {
        this.bookRepo = bookRepo;
        this.gBooksService = gBooksService;
    }

    @CrossOrigin(origins = "*")
    @QueryMapping
    public Author author(@Argument Integer id) {
        return new Author(id, "some author");
    }

    @CrossOrigin(origins = "*")
    @QueryMapping
    public Book book(@Argument Integer id) throws FileNotFoundException {
        return bookRepo.findById(id).orElseThrow(() -> new FileNotFoundException("Not found"));
    }

    @CrossOrigin(origins = "*")
    @QueryMapping
    public List<Book> books(@Argument Integer count) {
        return bookRepo.findAll().stream().filter(book -> book.getId() <= count).collect(Collectors.toList());
    }

    @QueryMapping
    public BooksResponse googleBooks(@Argument int count, @Argument String volume, @Argument int start) {
        return gBooksService.getBooks(volume ,count, start);
    }

//    @SchemaMapping
//    public Author getAuthor(@Argument Long id) {
//        return new Author(1L, "Tolkien");
//    }
}
