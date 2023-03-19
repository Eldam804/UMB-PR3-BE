package sk.umb.example.library.category.persistence;

import org.springframework.data.repository.CrudRepository;
import sk.umb.example.library.category.persistence.entity.GenreEntity;

public interface GenreRepository extends CrudRepository<GenreEntity,Long> {



}
