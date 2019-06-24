package bytechs.testTask.library.controllers;

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
    public User createUser(@RequestParam(value = "User", required = true) User user, @RequestParam(value = "roleUser", required = true) List<String> role) {
        return userServices.createUser(user, role);
    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public User editBook(@RequestParam(value = "login", required = true) String login, @RequestBody UserDescription userDescription) {
        return userServices.updateUserDiscription(login, userDescription);
    }

    @GetMapping(value = "/getByLogin")
    @ResponseStatus(value = HttpStatus.OK)
    public User getBookByName(@RequestParam(value = "login", required = true) String login) {
        return userServices.rerunUserByLogin(login);
    }
}
