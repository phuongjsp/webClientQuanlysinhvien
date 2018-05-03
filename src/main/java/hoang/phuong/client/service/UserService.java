package hoang.phuong.client.service;

import hoang.phuong.client.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(String email, String password);

    void logout();

    //ADd new User
    void confirmUser(Map<String, String> activeuserMap);

    boolean isKeyCodeActive(String keyCode);

    User ActiveUser(String keyCode, String password);


    //forget password and reset
    //Reset Password
    boolean isEmail(String email);

    void ConfirmResetPassword(String email, String path);

    boolean isKeyCodeResetPassword(String keyCode);

    User resetPassword(String keyCode, String password);

    //ROLE User
    boolean updatePassword(int id, String currentPassword, String newPassword);

    User updateUser(int id, Map<String, String> userMap);

    void deleteUser(int id, String password);

    User getUser(int id);
    //ROLE ADMIN
    List<User> listUsers();

}
