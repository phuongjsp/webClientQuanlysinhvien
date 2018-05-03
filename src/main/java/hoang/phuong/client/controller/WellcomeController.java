package hoang.phuong.client.controller;

import hoang.phuong.client.model.User;
import hoang.phuong.client.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
        return "users/login";
    }

    @RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model, HttpSession httpSession) {
        userService.logout();
        httpSession.removeAttribute("idUserAPI");
        model.addAttribute("messages", "Logout success.See you again !");

        return "messagesPage";
    }

    @RequestMapping(path = {"/profile"}, method = RequestMethod.GET)
    public String profile(Model model, @RequestParam("id") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "users/profile";
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
    public String ConfirmResetpasswordSuccess(Model model,
                                              HttpSession httpSession
            , @PathVariable("keycode") String keyCode, @RequestParam("password") String password) {
        User user = userService.resetPassword(keyCode, password);
        user = userService.login(user.getEmail(), password);
        httpSession.setAttribute("idUserAPI", user.getId());
        model.addAttribute("user", user);
        model.addAttribute("messages", "Update Password success.Please login");
        return "messagesPage";
    }

    @RequestMapping(path = {"/registation"}, method = RequestMethod.GET)
    public String registation(Model model) {
        model.addAttribute("pageModel", "Register New User");
        return "users/registation";
    }

    @RequestMapping(path = {"/registation"}, method = RequestMethod.POST)
    public String SendMailRegistation(Model model, @RequestParam Map<String, String> mapRegister) {
        if (userService.isEmail(mapRegister.get("email"))) {
            model.addAttribute("messages", "The Email is exist");
            return "users/registation";
        }
        model.addAttribute("messages", "The user has been registered,pleaase check your email to confirm.");
        userService.confirmUser(mapRegister);
        return "messagesPage";
    }

    @RequestMapping(path = {"/registation/{keycode}"}, method = RequestMethod.GET)
    public String ConfirmRegistation(Model model, @PathVariable("keycode") String keyCode) {

        if (userService.isKeyCodeActive(keyCode)) return "users/newPassword";
        model.addAttribute("messages", "The key code is not validate");
        return "messagesPage";
    }

    @RequestMapping(path = {"/registation/{keycode}"}, method = RequestMethod.POST)
    public String ConfirmRegistationSuccess(Model model
            , HttpSession httpSession
            , @PathVariable("keycode") String keyCode, @RequestParam("password") String password) {
        User user = userService.ActiveUser(keyCode, password);
        model.addAttribute("messages", "Register password success !");
        user = userService.login(user.getEmail(), password);
        httpSession.setAttribute("idUserAPI", user.getId());
        model.addAttribute("user", user);
        return "users/profile";
    }

    @RequestMapping(path = {"/updatepassword"}, method = RequestMethod.GET)
    public String updatePassword(Model model) {
        return "users/UpdatePassword";
    }

    @RequestMapping(path = {"/updatepassword"}, method = RequestMethod.POST)
    public String updatePasswordResult(Model model
            , @RequestParam(value = "id") int id
            , @RequestParam(value = "currentPassword") String currentPassword
            , @RequestParam(value = "newPassword") String newPassword) {
        try {
            if (userService.updatePassword(id, currentPassword, newPassword)) {
                model.addAttribute("messages", "Update password success !");
                return "messagesPage";
            }
        } catch (Exception e) {
            model.addAttribute("messages", "Update password success !");
            return "messagesPage";
        }
        model.addAttribute("messages", "new Password is  invalid");
        return "users/UpdatePassword";
    }

    @RequestMapping(path = {"/updateProfile"}, method = RequestMethod.GET)
    public String updateProfile(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("pageModel", "Update Profile");
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "users/registation";
    }

    @RequestMapping(path = {"/updateProfile"}, method = RequestMethod.POST)
    public String updateProfileResult(Model model
            , @RequestParam Map<String, String> mapUser) {
        Float inFloat = Float.valueOf(mapUser.get("id"));
        int id = (int) Math.round(inFloat);
        User user = userService.getUser(id);
        mapUser.remove("id");
        if (!user.getEmail().equals(mapUser.get("email"))) {
            if (!userService.isEmail(mapUser.get("email"))) {
                user.setEmail(mapUser.get("email"));
            } else {
                model.addAttribute("user", user);
                model.addAttribute("messages", "Email is Exist");
                return "users/registation";
            }
        }
        if (!user.getUserName().equals(mapUser.get("username"))) {
            user.setUserName(mapUser.get("username"));
        }
        if (!user.getUserLastName().equals(mapUser.get("userLastName"))) {
            user.setUserLastName(mapUser.get("userLastName"));
        }
        user = userService.updateUser(id, mapUser);
        model.addAttribute("messages", "Update Success !");
        model.addAttribute("user", user);
        return "users/profile";
    }
}
