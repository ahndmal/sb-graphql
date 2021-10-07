package com.anma.gr.sbgraphql.services;

import com.anma.gr.sbgraphql.model.BooksResponse;

public interface GBooksService {

    public BooksResponse getBooks(String volume);
    BooksResponse getBook(String id);
}
