package sk.umb.example.library;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(LibraryApplication.class, args);
    }
}
