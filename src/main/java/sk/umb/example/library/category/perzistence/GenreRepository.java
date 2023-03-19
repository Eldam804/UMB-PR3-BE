package sk.umb.example.library.category.perzistence;

import org.springframework.data.repository.CrudRepository;
import sk.umb.example.library.category.perzistence.entity.GenreEntity;

public interface GenreRepository extends CrudRepository<GenreEntity,Long> {



}
