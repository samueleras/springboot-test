package com.samuel.springboot_test;

import com.samuel.springboot_test.domain.Author;
import com.samuel.springboot_test.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final AuthorService authorService;

    public HelloWorldController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/hello")
    public String helloWorld(){
        Author author = Author.builder()
                .name("Samuel")
                .age(25)
                .build();

        authorService.createAuthor(author);

        return author.toString();
    }

}
