package com.samuel.springboot_test;

import com.samuel.springboot_test.domain.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld(){
        Author author = Author.builder()
                .name("Samuel")
                .age(25)
                .build();


        return author.toString();
    }

}
