package com.anma.gr.sbgraphql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksResponse {

    private String kind;
    private int totalItems;
    private BookResponse[] items;

    public BooksResponse(String id, int totalItems, BookResponse[] items) {
        this.kind = id;
        this.totalItems = totalItems;
        this.items = items;
    }

    public BooksResponse() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public BookResponse[] getItems() {
        return items;
    }

    public void setItems(BookResponse[] items) {
        this.items = items;
    }
}
