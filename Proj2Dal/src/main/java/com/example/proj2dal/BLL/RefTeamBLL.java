package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.ArbitragemEntity;
import com.example.proj2dal.Entity.ArbitroEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class RefTeamBLL {

    public static void createRefTeam(ArbitroEntity ref1, ArbitroEntity ref2, ArbitroEntity ref3) {
        // Verifica se algum dos árbitros tem ID zero, que é inválido para operações de banco de dados
        if (ref1.getIdArbitro() == 0 || ref2.getIdArbitro() == 0 || ref3.getIdArbitro() == 0) {
            throw new IllegalStateException("Um ou mais árbitros têm IDs inválidos (ID=0).");
        }

        EntityManager em = DBConnection.getEntityManager();
        try {
            if (em == null || !em.isOpen()) {
                throw new IllegalStateException("EntityManager is not available or is closed.");
            }

            em.getTransaction().begin();

            // Merge e verificação de IDs após o merge
            ref1 = em.merge(ref1);
            ref2 = em.merge(ref2);
            ref3 = em.merge(ref3);

            if (ref1.getIdArbitro() == 0 || ref2.getIdArbitro() == 0 || ref3.getIdArbitro() == 0) {
                throw new IllegalStateException("Um ou mais árbitros resultaram em IDs inválidos após merge.");
            }

            ArbitragemEntity team = new ArbitragemEntity();
            team.setArbitroByIdArbitro1(ref1);
            team.setArbitroByIdArbitro2(ref2);
            team.setArbitroByIdArbitro3(ref3);

            em.persist(team);
            em.getTransaction().commit();

            System.out.println("Team created successfully with ID: " + team.getIdArbitragem());
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Failed to create team: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void deleteRefTeam(ArbitragemEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(ref);
        em.getTransaction().commit();
    }

    public static ArbitragemEntity findRefTeam(int id){
        return DBConnection.getEntityManager().find(ArbitragemEntity.class, id);
    }

    public static List listRefTeam(){
        return DBConnection.getEntityManager().createQuery("from ArbitragemEntity ").getResultList();
    }

    public static int getNextAvailableId() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            // Cria uma query para encontrar o menor ID disponível que não está em sequência
            Query query = em.createNativeQuery(
                    "SELECT MIN(a.id_arbitro + 1) " +
                            "FROM arbitro a " +
                            "LEFT JOIN arbitro a2 ON a.id_arbitro + 1 = a2.id_arbitro " +
                            "WHERE a2.id_arbitro IS NULL"
            );

            Integer nextId = (Integer) query.getSingleResult();
            em.close();

            // Garante que o ID retornado nunca seja zero (no entanto, esse cenário é improvável se os IDs começam de 1)
            return (nextId != null && nextId > 0) ? nextId : 1;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            return 1; // Retorna 1 em caso de erro
        }
    }
}
