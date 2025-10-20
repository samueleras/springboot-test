package com.samuel.springboot_test.services;

import com.samuel.springboot_test.domain.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
}
