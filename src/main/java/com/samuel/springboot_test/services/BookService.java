package com.samuel.springboot_test.services;

import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.domain.BookEntity;
import com.samuel.springboot_test.domain.dto.BookDto;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookEntity createBook(BookEntity bookEntity);
}