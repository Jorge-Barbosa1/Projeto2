package org.example.proj2webapp.Controllers;

import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.Entity.JogoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/homePage")
    public String homePage(Model model) {
        List<JogoEntity> games = GameBLL.listGames();
        model.addAttribute("games", games);// Adiciona a lista de jogos ao modelo
        return "redirect:/Home.html";
    }

}
