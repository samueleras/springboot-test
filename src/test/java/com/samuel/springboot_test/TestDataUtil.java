package com.samuel.springboot_test;

import com.samuel.springboot_test.domain.Author;
import com.samuel.springboot_test.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){}

    public static Author createTestAuthorA() {
        return Author.builder()
                .name("Samuel")
                .age(25)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .name("Gerta")
                .age(26)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .name("Thomas")
                .age(18)
                .build();
    }

    public static Book createTestBookA(Author author) {
        return Book.builder()
                .isbn("AAAAAAAA")
                .title("Harry Potter 1")
                .author(author)
                .build();
    }

    public static Book createTestBookB(Author author) {
        return Book.builder()
                .isbn("BBBBBBBB")
                .title("Harry Potter 2")
                .author(author)
                .build();
    }

    public static Book createTestBookC(Author author) {
        return Book.builder()
                .isbn("CCCCCCC")
                .title("Harry Potter 3")
                .author(author)
                .build();
    }
}
