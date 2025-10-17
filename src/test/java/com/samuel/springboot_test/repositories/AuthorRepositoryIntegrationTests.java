package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.TestDataUtil;
import com.samuel.springboot_test.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {

        Author author = TestDataUtil.createTestAuthorA();

        Author savedAuthor = underTest.save(author);
        Optional<Author> result = underTest.findById(savedAuthor.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedAuthor);
    }

    /*
    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        Author authorB = TestDataUtil.createTestAuthorB();
        Author authorC = TestDataUtil.createTestAuthorC();

        Author savedAuthorA = underTest.create(authorA);
        Author savedAuthorB = underTest.create(authorB);
        Author savedAuthorC = underTest.create(authorC);
        List<Author> results = underTest.findMany();
        assertThat(results).isNotNull().hasSize(3).containsExactly(savedAuthorA, savedAuthorB, savedAuthorC);
    }*/

}