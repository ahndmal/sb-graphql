package com.anma.gr.sbgraphql.repo;

import com.anma.gr.sbgraphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
