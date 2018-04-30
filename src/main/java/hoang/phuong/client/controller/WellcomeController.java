package hoang.phuong.client.controller;

import hoang.phuong.client.model.User;
import hoang.phuong.client.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WellcomeController extends ExceptionHandlerController {

    private UserService userService;

    public WellcomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String hello() {
        return "WellcomeFile";
    }


    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = {"/login"}, method = RequestMethod.POST)
    public String loginResult(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.login(email, password);
        if (user != null) {
            return "WellcomeFile";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
    public String logout() {
        userService.logout();
        return "WellcomeFile";
    }


}
