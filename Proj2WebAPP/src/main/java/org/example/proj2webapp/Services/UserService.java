package org.example.proj2webapp.Services;

import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserService {
    public boolean register(String name, String username, BigInteger phone, String email, String password) {

        UtilizadorEntity user = new UtilizadorEntity();
        user.setUsername(username);
        user.setIsAdmin(0);
        user.setEmail(email);
        user.setNome(name);
        user.setTelefone(phone);
        user.setPassword(password);
        user.setIdUser(UserBLL.getNextAvailableId());

        if (UserBLL.existsByUsername(username) || UserBLL.existsByEmail(email))
            return false; // Nome de user ou e-mail já existem

        UserBLL.createUser(user);
        return true;
    }
}
