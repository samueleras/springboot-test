package com.samuel.springboot_test.dao.impl;

import com.samuel.springboot_test.TestDataUtil;
import com.samuel.springboot_test.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthoDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = TestDataUtil.createTestAuthorA();

        doAnswer(invocation -> {
            KeyHolder keyHolder = invocation.getArgument(1);
            keyHolder.getKeyList().add(Map.of("authorid", 1L));
            return 1; // rows affected
        }).when(jdbcTemplate).update(any(PreparedStatementCreator.class), any(KeyHolder.class));

        Author savedAuthor = underTest.create(author);

        verify(jdbcTemplate).update(any(PreparedStatementCreator.class), any(KeyHolder.class));
        assertThat(savedAuthor.getAuthorId()).isEqualTo(1L);
        assertThat(savedAuthor.getName()).isEqualTo(author.getName());
        assertThat(savedAuthor.getAge()).isEqualTo(author.getAge());
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT authorid, name, age FROM authors WHERE authorid = ? LIMIT 1"), ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L));
    }

    @Test
    public void testThatFindManyGeneratesTheCorrectSql(){
        underTest.findMany();
        verify(jdbcTemplate).query(eq("SELECT authorid, name, age FROM authors"), ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
    }

}
