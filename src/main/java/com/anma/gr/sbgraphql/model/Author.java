package com.anma.gr.sbgraphql.model;

public class Author {

    public Author(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public Author() {}

    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
