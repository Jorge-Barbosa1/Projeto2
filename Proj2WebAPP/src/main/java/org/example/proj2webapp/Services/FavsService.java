package org.example.proj2webapp.Services;

import com.example.proj2dal.BLL.FavoritesBLL;
import com.example.proj2dal.Entity.FavoritosEntity;
import org.example.proj2webapp.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavsService {

    public List<FavoritosEntity> getFavs(){
        Integer userId = AuthenticationService.getUserId();
        if (userId == null) {
            throw new IllegalStateException("User is not authenticated.");
        }
        List<FavoritosEntity> favsList = FavoritesBLL.listFavsByUser(userId);
        return favsList;
    }

    public boolean addFav(FavoritosEntity favorite) {
        try{
            FavoritesBLL.createFavorite(favorite);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
