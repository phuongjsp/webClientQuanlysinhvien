package hoang.phuong.client.service;

import hoang.phuong.client.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(String email, String password);

    void logout();

    //ADd new User
    void confirmUser(Map<String, String> activeuserMap, String path);

    boolean isKeyCodeActive(String keyCode);

    User ActiveUser(String keyCode);


    //forget password and reset
    //Reset Password
    boolean isEmail(String email);

    void ConfirmResetPassword(String email, String path);

    boolean isKeyCodeResetPassword(String keyCode);

    User resetPassword(String keyCode, String password);

    //ROLE User
    void updatePassword(int id, String currentPassword, String newPassword);

    User updateUser(User user);

    void deleteUser(int id, String password);

    User getUser(int id);
    //ROLE ADMIN
    List<User> listUsers();

}
