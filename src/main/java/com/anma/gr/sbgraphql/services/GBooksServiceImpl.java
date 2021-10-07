package com.anma.gr.sbgraphql.services;

import com.anma.gr.sbgraphql.model.BookResponse;
import com.anma.gr.sbgraphql.model.BooksResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GBooksServiceImpl implements GBooksService {

    private final Environment environment;
    private final String API_KEY;
    private final String REST_URL;
    private final Logger LOG = LoggerFactory.getLogger(GBooksServiceImpl.class);

    public GBooksServiceImpl(Environment environment) {
        this.environment = environment;
        this.API_KEY = environment.getProperty("GOOGLE_API_KEY");
        this.REST_URL = environment.getProperty("books.rest_api");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Override
    public BookResponse[] getBooks(String volume) {

        BooksResponse books = new RestTemplate().getForObject(REST_URL + "?q="+ volume +"?limit=20", BooksResponse.class);
        LOG.info(">>> Books " + books.getKind());

        return books.getItems();
    }

    @Override
    public BookResponse getBook(String id) {
        return null;
    }
}
