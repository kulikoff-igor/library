package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Role;
import bytechs.testTask.library.dao.model.User;
import bytechs.testTask.library.dao.model.UserDescription;
import bytechs.testTask.library.dao.repository.RoleRepository;
import bytechs.testTask.library.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service("userServices")
@Transactional("transactionManager")
public class UserServices {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;
    @Qualifier("roleRepository")
    @Autowired
    RoleRepository roleRepository;

    public User createUser(User user, List<String> roles) {
        HashSet<Role> userRoles = new HashSet<>();
        for (String role : roles) {
            Role userRole = roleRepository.findByRole(role);
            userRoles.add(userRole);
        }
        user.setRoles(userRoles);
        return userRepository.saveAndFlush(user);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User rerunUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User updateUserDiscription(String login, UserDescription userDescription) {
        User user = rerunUserByLogin(login);
        user.setUserDescription(userDescription);
        return createUser(user);
    }


}
