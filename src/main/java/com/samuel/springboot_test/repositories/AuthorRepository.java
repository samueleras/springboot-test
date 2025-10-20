package com.samuel.springboot_test.repositories;

import com.samuel.springboot_test.domain.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity,Long> {



}
