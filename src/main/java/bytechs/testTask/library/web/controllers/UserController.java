package bytechs.testTask.library.web.controllers;

import bytechs.testTask.library.dao.model.User;
import bytechs.testTask.library.dao.model.UserDescription;
import bytechs.testTask.library.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/api/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public User createUser(@RequestParam(value = "login") String login,@RequestParam(value = "password") String password,@RequestParam(value = "address") String address,@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName,  @RequestParam(value = "role") List<String> role,@RequestParam(value = "library") String library) {

        return userServices.createUser(login,password,address,name,lastName,role,library);

    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public User editBook(@RequestParam(value = "login", required = true) String login, @RequestBody UserDescription userDescription) {
        return userServices.updateUserDescription(login, userDescription);
    }

    @GetMapping(value = "/getByLogin")
    @ResponseStatus(value = HttpStatus.OK)
    public User getBookByName(@RequestParam(value = "login", required = true) String login) {
        return userServices.rerunUserByLogin(login);
    }
}
