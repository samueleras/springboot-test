package com.samuel.springboot_test.services.impl;

import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.domain.BookEntity;
import com.samuel.springboot_test.repositories.AuthorRepository;
import com.samuel.springboot_test.repositories.BookRepository;
import com.samuel.springboot_test.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

}
