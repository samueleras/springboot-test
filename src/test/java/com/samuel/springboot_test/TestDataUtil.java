package com.samuel.springboot_test;

import com.samuel.springboot_test.domain.Author;

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
}
