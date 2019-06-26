package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Role;
import bytechs.testTask.library.dao.model.User;
import bytechs.testTask.library.dao.model.UserDescription;
import bytechs.testTask.library.dao.repository.RoleRepository;
import bytechs.testTask.library.dao.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
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
    @Autowired
    UserDescriptionServices userDescriptionServices;
    @Autowired
    LibraryServices libraryServices;


    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User rerunUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User updateUserDescription(String login, UserDescription userDescription) {
        User user = rerunUserByLogin(login);
        user.setUserDescription(userDescription);
        return createUser(user);
    }


    public User createUser(String login, String password, String address, String name, String lastName, List<String> roles, String library) {
        User user = new User();
        UserDescription userDescription = new UserDescription(name, lastName, address);

        HashSet<Role> userRoles = new HashSet<>();
        for (String role : roles) {
            Role userRole = roleRepository.findByRole(role);
            userRoles.add(userRole);
        }
        user.setLogin(login);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setRoles(userRoles);
        user.setLibrary(libraryServices.returnLibraryByName(library));
        user.setUserDescription(userDescriptionServices.createUserDescription(userDescription));
        return userRepository.saveAndFlush(user);
    }
}
