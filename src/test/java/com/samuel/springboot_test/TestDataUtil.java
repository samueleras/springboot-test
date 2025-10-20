package com.samuel.springboot_test;

import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.domain.BookEntity;
import com.samuel.springboot_test.domain.dto.AuthorDto;
import com.samuel.springboot_test.domain.dto.BookDto;


public final class TestDataUtil {

    private TestDataUtil() {}

    // ==========================
    // Author Entities
    // ==========================
    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .name("Samuel")
                .age(25)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .name("Gerta")
                .age(26)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .name("Thomas")
                .age(18)
                .build();
    }

    // ==========================
    // Author DTOs
    // ==========================
    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .name("Samuel")
                .age(25)
                .build();
    }

    public static AuthorDto createTestAuthorDtoB() {
        return AuthorDto.builder()
                .name("Gerta")
                .age(26)
                .build();
    }

    public static AuthorDto createTestAuthorDtoC() {
        return AuthorDto.builder()
                .name("Thomas")
                .age(18)
                .build();
    }

    // ==========================
    // Book Entities
    // ==========================
    public static BookEntity createTestBookA(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("AAAAAAAA")
                .title("Harry Potter 1")
                .author(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("BBBBBBBB")
                .title("Harry Potter 2")
                .author(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("CCCCCCC")
                .title("Harry Potter 3")
                .author(authorEntity)
                .build();
    }

    // ==========================
    // Book DTOs
    // ==========================
    public static BookDto createTestBookDtoA(AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("AAAAAAAA")
                .title("Harry Potter 1")
                .author(authorDto)
                .build();
    }

    public static BookDto createTestBookDtoB(AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("BBBBBBBB")
                .title("Harry Potter 2")
                .author(authorDto)
                .build();
    }

    public static BookDto createTestBookDtoC(AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("CCCCCCC")
                .title("Harry Potter 3")
                .author(authorDto)
                .build();
    }
}
