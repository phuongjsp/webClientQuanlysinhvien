package hoang.phuong.client.service;

import hoang.phuong.client.model.User;

import java.util.List;

public interface UserService {
    User login(String email, String password);

    void logout();

    //New User
    void newUser(User user);

    User activeUser(String keyCode);

    //forget password and reset
    boolean forgetPassword(String email);

    boolean isKeyCodeResetPassword(String keycode);

    void confirmResetPassword(String keyCode);


    //ROLE User
    void updatePassword(int id, String currentPassword, String newPassword);

    User updateUser(User user);

    void deleteUser(int id);

    //ROLE ADMIN
    List<User> listUsers();

}
