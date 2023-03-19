package sk.umb.example.library.borrowings.persistence;

import org.springframework.data.repository.CrudRepository;
import sk.umb.example.library.borrowings.persistence.entity.BorrowingsEntity;

public interface BorrowingsRepository extends CrudRepository<BorrowingsEntity, Long> {
}
