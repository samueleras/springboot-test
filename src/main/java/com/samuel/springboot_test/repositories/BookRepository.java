package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
