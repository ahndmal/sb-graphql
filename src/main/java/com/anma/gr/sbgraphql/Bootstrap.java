package com.anma.gr.sbgraphql;

import com.anma.gr.sbgraphql.model.Author;
import com.anma.gr.sbgraphql.model.Book;
import com.anma.gr.sbgraphql.repo.AuthorRepository;
import com.anma.gr.sbgraphql.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    private final BookRepo bookRepo;
    private final AuthorRepository authorRepository;

    public Bootstrap(BookRepo bookRepo, AuthorRepository authorRepository) {
        this.bookRepo = bookRepo;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createAuthors();
        loadData();
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
        Book witcher = new Book( 2, "LOTR");
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
    }
}
