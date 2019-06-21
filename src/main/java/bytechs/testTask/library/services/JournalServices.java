package bytechs.testTask.library.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("journalServices")
@Transactional("transactionManager")
public class JournalServices {
}
