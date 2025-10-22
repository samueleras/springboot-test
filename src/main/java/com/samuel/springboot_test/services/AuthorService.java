package com.samuel.springboot_test.services;

import com.samuel.springboot_test.domain.AuthorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
    List<AuthorEntity> listAuthors();
}
