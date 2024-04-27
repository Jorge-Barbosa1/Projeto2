package BLL;

import Entity.JogoEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameBLL {

    public static void createGame(JogoEntity game){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();
    }

    public static void deleteGame(JogoEntity game){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(game);
        em.getTransaction().commit();
    }

    public static JogoEntity findGame(int id){
        return DBConnection.getEntityManager().find(JogoEntity.class,id);
    }

    public static List listGames(){
        return DBConnection.getEntityManager().createQuery("from JogoEntity ").getResultList();
    }

    //Não sei se faz sentido
    public static List listGameByTeam(String name){
        return  DBConnection.getEntityManager().createQuery("from JogoEntity where equipa1 like ?1 ").setParameter(1,name).getResultList();
    }
}
