package org.example.proj2webapp.Services;
import com.example.proj2dal.Entity.UtilizadorEntity;
import org.springframework.stereotype.Service;
import com.example.proj2dal.BLL.UserBLL;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        UtilizadorEntity user= UserBLL.logUser(username, password);
        return user != null; // Retorna true se as credenciais forem válidas, false caso contrário
    }
}