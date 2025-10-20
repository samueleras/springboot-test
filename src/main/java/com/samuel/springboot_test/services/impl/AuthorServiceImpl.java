package com.samuel.springboot_test.services.impl;

import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.repositories.AuthorRepository;
import com.samuel.springboot_test.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

}
