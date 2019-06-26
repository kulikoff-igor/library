package bytechs.testTask.library.web.configSecurity;

import bytechs.testTask.library.dao.model.Role;
import bytechs.testTask.library.dao.model.User;
import bytechs.testTask.library.services.UserServices;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ServiceAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserServices userServices;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println(name + "  " + password);
        User user = userServices.rerunUserByLogin(name);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            Set<Role> roles= user.getRoles();
            System.out.println(roles.size());
            for (Role role : roles) {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));

            }
            return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
