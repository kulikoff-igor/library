package bytechs.testTask.library.services;

import bytechs.testTask.library.model.User;
import bytechs.testTask.library.model.UserDescription;
import bytechs.testTask.library.repository.UserDescriptionRepository;
import bytechs.testTask.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServices")
@Transactional("transactionManager")
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
