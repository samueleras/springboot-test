package com.samuel.springboot_test.dao.impl;

import com.samuel.springboot_test.dao.AuthorDao;
import com.samuel.springboot_test.dao.BookDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
