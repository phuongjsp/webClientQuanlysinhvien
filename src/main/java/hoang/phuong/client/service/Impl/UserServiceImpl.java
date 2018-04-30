package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.User;
import hoang.phuong.client.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends AbstractService<User> implements UserService {
    public UserServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public User login(String email, String password) {
        try {
            User user = gson.fromJson(UserAPIReturn("api/login?email=" + email + "&password=" + password, HttpMethod.POST), User.class);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void logout() {
        UserAPI("api/logout", HttpMethod.POST);
    }

    @Override
    public void newUser(User user) {

    }

    @Override
    public User activeUser(String keyCode) {
        return null;
    }

    @Override
    public boolean forgetPassword(String email) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isKeyCodeResetPassword(String keycode) {
        return false;
    }

    @Override
    public void confirmResetPassword(String keyCode) {

    }

    @Override
    public void updatePassword(int id, String currentPassword, String newPassword) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
