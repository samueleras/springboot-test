package com.samuel.springboot_test.dao.impl;

import com.samuel.springboot_test.dao.AuthorDao;
import com.samuel.springboot_test.domain.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author create(Author author) {

        GeneratedKeyHolder keyholder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            @NonNull
            public PreparedStatement createPreparedStatement(@NonNull Connection con) throws SQLException {
                PreparedStatement pst = con.prepareStatement("INSERT INTO authors (name, age) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, author.getName());
                pst.setInt(2, author.getAge());
                return pst;
            }
        };
        jdbcTemplate.update(psc, keyholder);

        Map<String, Object> keymap = keyholder.getKeys();

        if (keymap == null) {
            throw new DataAccessException("No generated key returned") {
            };
        }

        Long key = (Long) keymap.get("authorid");

        author.setAuthorId(key);

        return author;
    }

    @Override
    public Optional<Author> findOne(long authorId) {
        List<Author> results = jdbcTemplate.query("SELECT authorid, name, age FROM authors WHERE authorid = ? LIMIT 1", new AuthorRowMapper(), authorId);

        return results.stream().findFirst();
    }

    @Override
    public List<Author> findMany() {
        return jdbcTemplate.query("SELECT authorid, name, age FROM authors", new AuthorRowMapper());
    }

    public static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder().authorId(rs.getLong("authorid")).name(rs.getString("name")).age(rs.getInt("age")).build();
        }
    }

}
