package bytechs.testTask.library.services;

import bytechs.testTask.library.model.Library;
import bytechs.testTask.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("libraryServices")
@Transactional("transactionManager")
public class LibraryServices {
    @Autowired
    LibraryRepository libraryRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.saveAndFlush(library);
    }

    public Library returnLibraryByName(String nameLibrary) {
        return libraryRepository.findByNameLibrary(nameLibrary);
    }



    public List<Library> retunAllLibrary() {
        return libraryRepository.findAll();

    }

}
