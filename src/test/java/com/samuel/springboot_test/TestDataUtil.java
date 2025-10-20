package com.samuel.springboot_test;

, import com.samuel.springboot_test.domain.AuthorEntity;
import com.samuel.springboot_test.domain.BookEntity;

public final class TestDataUtil {

    private TestDataUtil(){}

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

    public static BookEntity createTestBookA(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("AAAAAAAA")
                .title("Harry Potter 1")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("BBBBBBBB")
                .title("Harry Potter 2")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("CCCCCCC")
                .title("Harry Potter 3")
                .authorEntity(authorEntity)
                .build();
    }
}
