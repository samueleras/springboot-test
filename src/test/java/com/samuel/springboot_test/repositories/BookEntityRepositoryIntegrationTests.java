package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.TestDataUtil;
import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.domain.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
        BookEntity savedBookEntity = underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(savedBookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBookEntity);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntity);
        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntity);
        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntity);
        BookEntity savedBookEntityA = underTest.save(bookEntityA);
        BookEntity savedBookEntityB = underTest.save(bookEntityB);
        BookEntity savedBookEntityC = underTest.save(bookEntityC);
        List<BookEntity> results = (List<BookEntity>) underTest.findAll();
        assertThat(results).isNotNull().hasSize(3).containsExactly(savedBookEntityA, savedBookEntityB, savedBookEntityC);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
        BookEntity savedBookEntity = underTest.save(bookEntity);
        savedBookEntity.setTitle("UPDATED");
        underTest.save(savedBookEntity);
        Optional<BookEntity> result = underTest.findById(savedBookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBookEntity);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
        BookEntity savedBookEntity = underTest.save(bookEntity);
        underTest.delete(savedBookEntity);
        Optional<BookEntity> result = underTest.findById(savedBookEntity.getIsbn());
        assertThat(result).isEmpty();
    }
}

