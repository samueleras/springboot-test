package com.samuel.springboot_test.services;

import com.samuel.springboot_test.dao.AuthorDao;
import com.samuel.springboot_test.domain.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void createAuthor(Author author) {
        authorDao.create(author);
    }
}

