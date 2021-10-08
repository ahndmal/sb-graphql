package com.anma.gr.sbgraphql;

import com.anma.gr.sbgraphql.model.Author;
import com.anma.gr.sbgraphql.model.Book;
import com.anma.gr.sbgraphql.repo.AuthorRepository;
import com.anma.gr.sbgraphql.repo.BookRepo;
import com.anma.gr.sbgraphql.services.GBooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    private final BookRepo bookRepo;
    private final AuthorRepository authorRepository;
    private final Environment environment;
    private final GBooksService gBooksService;

    public Bootstrap(BookRepo bookRepo, AuthorRepository authorRepository, Environment environment, GBooksService gBooksService) {
        this.bookRepo = bookRepo;
        this.authorRepository = authorRepository;
        this.environment = environment;
        this.gBooksService = gBooksService;
    }

    @Override
    public void run(String... args) throws Exception {
        createAuthors();
        loadData();
//        gBooksService.getBooks("quilting");
    }

    private void createAuthors() {
        Author tolkien = new Author(1, "R.R. Tolkien");
        Author dumas = new Author(2, "Ch. Dumas");
        Author sapkovski = new Author(3, "A. Sapkovski");
        authorRepository.save(tolkien);
        authorRepository.save(dumas);
        authorRepository.save(sapkovski);
    }

    private void loadData() {
        LOGGER.info(">>> CReating books: ");
        Book lotr = new Book( 1,"LOTR");
        lotr.setAuthor(authorRepository.getById(1));
        Book witcher = new Book( 2, "Witcher");
        witcher.setAuthor(authorRepository.getById(3));
        Book cheburashka = new Book( 3, "Cheburashka");
        cheburashka.setAuthor(authorRepository.getById(2));
        Book dune = new Book( 4, "Dune");
        dune.setAuthor(authorRepository.getById(1));
        Book starWars = new Book( 5, "Star Wars");
        starWars.setAuthor(authorRepository.getById(3));
        bookRepo.save(lotr);
        bookRepo.save(witcher);
        bookRepo.save(cheburashka);
        bookRepo.save(dune);
        bookRepo.save(starWars);
        LOGGER.info(">>> created " + bookRepo.count() + " books");

//        LOGGER.info(String.valueOf(gBooksService.getBooks("quirling", 40, 1).getItems().length) + " books retrieved");
    }
}
