package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
