package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.TestDataUtil;
import com.samuel.springboot_test.domain.AuthorEntity;
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
public class AuthorEntityRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        AuthorEntity savedAuthorEntity = underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(savedAuthorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedAuthorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorC();
        AuthorEntity savedAuthorEntityA = underTest.save(authorEntityA);
        AuthorEntity savedAuthorEntityB = underTest.save(authorEntityB);
        AuthorEntity savedAuthorEntityC = underTest.save(authorEntityC);
        List<AuthorEntity> results = (List<AuthorEntity>) underTest.findAll();
        assertThat(results).isNotNull().hasSize(3).containsExactly(savedAuthorEntityA, savedAuthorEntityB, savedAuthorEntityC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        AuthorEntity savedAuthorEntity = underTest.save(authorEntity);
        savedAuthorEntity.setName("UPDATED");
        underTest.save(savedAuthorEntity);
        Optional<AuthorEntity> result = underTest.findById(savedAuthorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedAuthorEntity);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        AuthorEntity savedAuthorEntity = underTest.save(authorEntity);
        underTest.delete(savedAuthorEntity);
        Optional<AuthorEntity> result = underTest.findById(savedAuthorEntity.getId());
        assertThat(result).isEmpty();
    }

}