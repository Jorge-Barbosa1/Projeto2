package org.example.proj2webapp.Services;

import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2dal.Entity.JogadorEntity;
import org.example.proj2webapp.DTO.PlayerDTO;
import org.example.proj2webapp.DTO.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {

    public List<TeamDTO> getTeams(){
        List<EquipaEntity> teams = TeamBLL.listTeams();
        return teams.stream().map(e ->new TeamDTO(e.getIdEquipa(), e.getNome())).toList();
    }

    public List<PlayerDTO> getPlayerByTeam(Integer teamId){
        List<JogadorEntity> players = TeamBLL.listPlayersByTeam(teamId);
        return players.stream().map(p -> new PlayerDTO(p.getIdJogador(),p.getNome(),p.getIdEquipa())).toList();
    }
}