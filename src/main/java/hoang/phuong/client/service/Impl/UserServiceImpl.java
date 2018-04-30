package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.User;
import hoang.phuong.client.service.UserService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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
    public void confirmUser(Map<String, String> activeuserMap, String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(activeuserMap, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9966/api/users", request, String.class);
    }

    @Override
    public boolean isKeyCodeActive(String keyCode) {
        String body = UserAPIReturn("api/users/active/" + keyCode, HttpMethod.GET);
        if (body.equals("true")) return true;
        return false;
    }

    @Override
    public User ActiveUser(String keyCode) {
        return gson.fromJson(UserAPIReturn("api/users/active/" + keyCode, HttpMethod.POST), User.class);

    }

    @Override
    public boolean isEmail(String email) {
        System.out.println(email);
        String body = UserAPIReturn("api/users/isemail?email=" + email, HttpMethod.GET);
        if (body.equals("true")) return true;
        return false;
    }

    @Override
    public void ConfirmResetPassword(String email, String path) {
        UserAPI("api/users/forgetpass?email=" + email + "&path=" + path, HttpMethod.POST);
    }

    @Override
    public boolean isKeyCodeResetPassword(String keyCode) {
        String body = UserAPIReturn("api/users/reset/" + keyCode, HttpMethod.GET);
        if (body.equals("true")) return true;
        return false;
    }

    @Override
    public User resetPassword(String keyCode, String password) {
        System.out.println(password);
        return gson.fromJson(UserAPIReturn("api/users/reset/" + keyCode + "?password=" + password, HttpMethod.POST), User.class);
    }


    @Override
    public void updatePassword(int id, String currentPassword, String newPassword) {
        UserAPI("api/users/newpassword/" + id + "?currentPassword=" + currentPassword + "&newPassword=" + newPassword, HttpMethod.POST);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id, String password) {
        UserAPI("api/users/" + id + "?password=" + password, HttpMethod.DELETE);
    }

    @Override
    public User getUser(int id) {
        return gson.fromJson(UserAPIReturn("api/users/" + id, HttpMethod.GET), User.class);
    }

    @Override
    public List<User> listUsers() {
        return listTByJsonString(UserAPIReturn("api/users", HttpMethod.GET));
    }


}
