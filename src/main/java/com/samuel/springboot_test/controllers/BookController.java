package com.samuel.springboot_test.controllers;

import com.samuel.springboot_test.domain.BookEntity;
import com.samuel.springboot_test.domain.dto.BookDto;
import com.samuel.springboot_test.mappers.Mapper;
import com.samuel.springboot_test.services.BookService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class BookController {

    private BookService bookService;
    private Mapper<BookEntity, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto, HttpServletResponse httpServletResponse) {
        BookEntity newBookEntity = bookMapper.mapFrom(bookDto);
        newBookEntity.setIsbn(isbn);
        BookEntity savedBookEntity = bookService.createBook(newBookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }

}
