package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.TestDataUtil;
import com.samuel.springboot_test.domain.Author;
import com.samuel.springboot_test.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        Book savedBook = underTest.save(book);
        Optional<Book> result = underTest.findById(savedBook.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book bookA = TestDataUtil.createTestBookA(author);
        Book bookB = TestDataUtil.createTestBookB(author);
        Book bookC = TestDataUtil.createTestBookC(author);
        Book savedBookA = underTest.save(bookA);
        Book savedBookB = underTest.save(bookB);
        Book savedBookC = underTest.save(bookC);
        List<Book> results = (List<Book>) underTest.findAll();
        assertThat(results).isNotNull().hasSize(3).containsExactly(savedBookA, savedBookB, savedBookC);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        Book savedBook = underTest.save(book);
        savedBook.setTitle("UPDATED");
        underTest.save(savedBook);
        Optional<Book> result = underTest.findById(savedBook.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);
    }
}
