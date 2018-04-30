package hoang.phuong.client.controller;

import hoang.phuong.client.model.User;
import hoang.phuong.client.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@SessionAttributes("idUser")
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
    public String loginResult(Model model, HttpSession httpSession, @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.login(email, password);
        if (user != null) {
            httpSession.setAttribute("idUserAPI", user.getId());
            model.addAttribute("user", user);
            return "users/profile";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model, HttpSession httpSession) {
        userService.logout();
        httpSession.removeAttribute("idUserAPI");
        model.addAttribute("messages", "Logout success.See you again !");

        return "messagesPage";
    }

    @RequestMapping(path = {"/forgetPassword"}, method = RequestMethod.GET)
    public String forgetPassword() {
        return "users/forgetPassword";
    }

    @RequestMapping(path = {"/forgetPassword"}, method = RequestMethod.POST)
    public String getEmailforgetPassword(Model model, @RequestParam("email") String email) {
        if (userService.isEmail(email)) {
            userService.ConfirmResetPassword(email, "http://localhost:6699/forgetPassword/");
            model.addAttribute("messages", "Please check your email then get key code reset password");
            return "messagesPage";
        }
        model.addAttribute("error", "email is not found");
        return "users/forgetPassword";
    }

    @RequestMapping(path = {"/forgetPassword/{keycode}"}, method = RequestMethod.GET)
    public String ConfirmResetpassword(Model model, @PathVariable("keycode") String keyCode) {

        if (userService.isKeyCodeResetPassword(keyCode)) return "users/newPassword";
        model.addAttribute("messages", "The kry code is not validate");
        return "messagesPage";
    }

    @RequestMapping(path = {"/forgetPassword/{keycode}"}, method = RequestMethod.POST)
    public String ConfirmResetpasswordSuccess(Model model
            , HttpSession httpSession
            , @PathVariable("keycode") String keyCode, @RequestParam("password") String password) {
        User user = userService.resetPassword(keyCode, password);
        model.addAttribute("messages", "Update password success !");
        httpSession.setAttribute("idUserAPI", user.getId());
        model.addAttribute("user", user);
        return "users/profile";
    }

}
