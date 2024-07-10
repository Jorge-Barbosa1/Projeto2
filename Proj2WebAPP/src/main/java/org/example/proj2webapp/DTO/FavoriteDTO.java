package org.example.proj2webapp.DTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FavoriteDTO {
    public Integer idFavorite;
    public Integer userId;
    public String playerName;
    public String teamName;

    public FavoriteDTO(Integer idFavorite, Integer userId, String playerName, String teamName) {
        this.idFavorite = idFavorite;
        this.userId = userId;
        this.playerName = playerName;
        this.teamName = teamName;
    }

}
