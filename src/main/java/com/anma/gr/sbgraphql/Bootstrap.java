package com.anma.gr.sbgraphql;

import com.anma.gr.sbgraphql.model.Book;
import com.anma.gr.sbgraphql.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    private final BookRepo bookRepo;

    public Bootstrap(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        LOGGER.info(">>> CReating books: ");
        Book lotr = new Book( 1,"LOTR");
        Book witcher = new Book( 2, "LOTR");
        Book cheburashka = new Book( 3, "Cheburashka");
        Book dune = new Book( 4, "Dune");
        Book starWars = new Book( 5, "Star Wars");
        bookRepo.save(lotr);
        bookRepo.save(witcher);
        bookRepo.save(cheburashka);
        bookRepo.save(dune);
        bookRepo.save(starWars);
        LOGGER.info(">>> created " + bookRepo.count() + " books");
    }
}
