package com.anma.gr.sbgraphql.repo;

import com.anma.gr.sbgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookRepo extends JpaRepository<Book, Integer> {


}
