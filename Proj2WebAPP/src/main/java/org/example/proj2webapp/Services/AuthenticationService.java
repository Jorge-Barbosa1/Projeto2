package org.example.proj2webapp.Services;
import com.example.proj2dal.Entity.UtilizadorEntity;
import org.springframework.stereotype.Service;
import com.example.proj2dal.BLL.UserBLL;




@Service
public class AuthenticationService {
    private static Integer userId;
    public boolean authenticate(String username, String password) {
        UtilizadorEntity user= UserBLL.logUser(username, password);
        if (user != null) {
            setUserId(user.getIdUser());
            return true;
        }
        return false;
    }
    public static Integer getUserId() {
        return userId;
    }

    public static void setUserId(Integer userId) {
        AuthenticationService.userId = userId;
    }

}