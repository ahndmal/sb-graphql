package com.anma.gr.sbgraphql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private Integer id;
    @ManyToOne
    private Author author;
    private String title;

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book() {}

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return author.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
