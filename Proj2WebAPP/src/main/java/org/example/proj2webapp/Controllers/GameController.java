package org.example.proj2webapp.Controllers;

import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.Entity.JogoEntity;
import org.example.proj2webapp.DTO.GameDTO;
import org.example.proj2webapp.Services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class GameController {

    @GetMapping("/jogos")
    public ResponseEntity<List<JogoEntity>> listJogos() {
        List<JogoEntity> games = GameBLL.listGames();
        return ResponseEntity.ok(games);
    }
}
