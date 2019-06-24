package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.UserDescription;
import bytechs.testTask.library.dao.repository.UserDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDescriptionServices")
@Transactional("transactionManager")
public class UserDescriptionServices {
    @Qualifier("userDescriptionRepository")
    @Autowired
    UserDescriptionRepository userDescriptionRepository;

    public UserDescription createUserDescription(UserDescription userDescription) {
        return userDescriptionRepository.saveAndFlush(userDescription);
    }
}
