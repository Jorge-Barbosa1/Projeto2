package org.example.proj2webapp.Controllers;

import com.example.proj2dal.Entity.JogoEntity;
import org.example.proj2webapp.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.proj2dal.BLL.GameBLL;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/api/jogos")
    public List<JogoEntity> getAllGames() {
        return GameBLL.listGames();
    }

}