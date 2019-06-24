package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("libraryRepository")
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Library findByNameLibrary(String libraryName);
}
