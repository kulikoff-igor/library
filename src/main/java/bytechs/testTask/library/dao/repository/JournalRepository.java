package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("journalRepository")
public interface JournalRepository  extends JpaRepository<Journal, Integer> {
}
