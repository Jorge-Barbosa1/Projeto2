package org.example.proj2webapp.Controllers;

import com.example.proj2dal.Entity.FavoritosEntity;
import org.example.proj2webapp.Services.FavsService;
import org.example.proj2webapp.Services.TeamsService;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
