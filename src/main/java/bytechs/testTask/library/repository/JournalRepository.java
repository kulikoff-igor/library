package bytechs.testTask.library.repository;

import bytechs.testTask.library.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository  extends JpaRepository<Journal, Integer> {
}
