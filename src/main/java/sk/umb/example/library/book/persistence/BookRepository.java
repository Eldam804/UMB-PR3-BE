package sk.umb.example.library.book.persistence;

import org.springframework.data.repository.CrudRepository;
import sk.umb.example.library.book.persistence.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
