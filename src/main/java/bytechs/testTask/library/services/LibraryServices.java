package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Library;
import bytechs.testTask.library.dao.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("libraryServices")
@Transactional("transactionManager")
public class LibraryServices {
    @Qualifier("libraryRepository")
    @Autowired
    LibraryRepository libraryRepository;

    public Library createLibrary(String nameLibrary) {
        Library library = new Library();
        library.setNameLibrary(nameLibrary);
        return libraryRepository.saveAndFlush(library);
    }

    public Library returnLibraryByName(String nameLibrary) {
        return libraryRepository.findByNameLibrary(nameLibrary);
    }


    public List<Library> retunAllLibrary() {
        return libraryRepository.findAll();

    }

}
