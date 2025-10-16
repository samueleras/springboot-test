package com.samuel.springboot_test.dao;

import com.samuel.springboot_test.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    Author create(Author author);

    Optional<Author> findOne(long l);

    List<Author> findMany();
}
