package bytechs.testTask.library.repository;

import bytechs.testTask.library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Library findByNameLibrary(String libraryName);
}
