package org.example.proj2webapp.Controllers;

import com.example.proj2dal.BLL.FavoritesBLL;
import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2dal.Entity.FavoritosEntity;
import com.example.proj2dal.Entity.JogadorEntity;
import org.example.proj2webapp.DTO.FavoriteDTO;
import org.example.proj2webapp.DTO.PlayerDTO;
import org.example.proj2webapp.DTO.TeamDTO;
import org.example.proj2webapp.DTO.UserDTO;
import org.example.proj2webapp.Services.AuthenticationService;
import org.example.proj2webapp.Services.FavsService;
import org.example.proj2webapp.Services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AddFavController {

    @Autowired
    private FavsService favsService;

    @Autowired
    private TeamsService teamsService;

    @GetMapping("/teams")
    @ResponseBody
    public List<TeamDTO> getTeams(){
        System.out.println("Getting teams:"+ teamsService.getTeams().size());
        return teamsService.getTeams();
    }

    @GetMapping("/teams/{teamId}/players")
    @ResponseBody
    public List<PlayerDTO> getPlayers(@PathVariable Integer teamId){
        return teamsService.getPlayerByTeam(teamId);
    }

    @PostMapping("/AddFav")
    @ResponseBody
    public ResponseEntity<String> addFav(@RequestBody FavoriteDTO favoriteDTO){
        Integer userId = AuthenticationService.getUserId();
        FavoritosEntity favorite = new FavoritosEntity();

        favorite.setIdFavoritos(BigInteger.valueOf(FavoritesBLL.getNextAvailableId()));
        favorite.setUserId(userId);
        favorite.setJogadores(favoriteDTO.getPlayerName());
        favorite.setEquipa(favoriteDTO.getTeamName());

        boolean sucess = favsService.addFav(favorite);
        if(sucess) {
            return ResponseEntity.ok("Favorito adicionado com sucesso");
        }else{
            return ResponseEntity.badRequest().body("Erro ao adicionar favorito");
        }
    }

    @GetMapping("/addFavorite")
    public String showAddFavPage(){
        return "AddFavorite.html";
    }
}
