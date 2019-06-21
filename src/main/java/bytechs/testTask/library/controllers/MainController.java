package bytechs.testTask.library.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

public class MainController {
    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String index() {
        return "library";
    }
    @RequestMapping(value = "/library/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/library/user", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequestMapping("/")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("library/");
        return redirectView;
    }
}
