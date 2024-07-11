package org.example.proj2webapp.Controllers;

import com.example.proj2dal.Entity.FavoritosEntity;
import org.example.proj2webapp.Services.FavsService;
import org.example.proj2webapp.Services.TeamsService;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/api")
public class FavsController {

    @Autowired
    private FavsService favsService;


    @GetMapping("/favoritos")
    public String getFavsPage(){
        return "Favs.html";
    }

    @GetMapping("/favs")
    @ResponseBody
    public List<FavoritosEntity> getFavs(){
        return favsService.getFavs();
    }

    @DeleteMapping("/favs/{favoriteId}")
    @ResponseBody
    public ResponseEntity<String> deleteFav(@PathVariable BigInteger favoriteId){
        boolean sucess = favsService.deleteFav(favoriteId);
        if(sucess){
            return ResponseEntity.ok("Favorite deleted.");
        }else{
            return ResponseEntity.badRequest().body("Error deleting favorite.");
        }
    }
}
