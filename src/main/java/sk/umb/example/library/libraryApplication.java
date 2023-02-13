package sk.umb.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class libraryApplication {

    public static void main(String[] args) {
        System.out.println("Hello Spring Aplication");

        SpringApplication.run(libraryApplication.class, args);


    }


}
