package com.anma.gr.sbgraphql.services;

import com.anma.gr.sbgraphql.model.BookResponse;

public interface GBooksService {

    public BookResponse[] getBooks(String volume);
    BookResponse getBook(String id);
}
