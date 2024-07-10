package org.example.proj2webapp.Services;

import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.Entity.JogoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    public List<JogoEntity> getGames(){
        List<JogoEntity> games = GameBLL.listGames();
        return games;
    }
}
