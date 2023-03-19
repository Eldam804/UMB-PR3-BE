package sk.umb.example.library.category.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.category.persistence.entity.GenreEntity;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity,Long> {
}
