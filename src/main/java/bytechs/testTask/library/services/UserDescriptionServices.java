package bytechs.testTask.library.services;

import bytechs.testTask.library.model.UserDescription;
import bytechs.testTask.library.repository.UserDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDescriptionServices")
@Transactional("transactionManager")
public class UserDescriptionServices {
    @Autowired
    UserDescriptionRepository userDescriptionRepository;

    public UserDescription createUserDescription(UserDescription userDescription) {
        return userDescriptionRepository.saveAndFlush(userDescription);
    }
}
