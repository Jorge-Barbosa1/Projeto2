package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.ArbitragemEntity;
<<<<<<< HEAD
import com.example.proj2dal.Entity.ArbitroEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
=======
import jakarta.persistence.EntityManager;
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284

import java.util.List;

public class RefTeamBLL {
<<<<<<< HEAD
    public static void createRefTeam(ArbitroEntity ref1, ArbitroEntity ref2, ArbitroEntity ref3) {
        EntityManager em = null;
        try {
            em = DBConnection.getEntityManager();
            if (em == null || !em.isOpen()) {
                throw new IllegalStateException("EntityManager is not available or is closed.");
            }

            em.getTransaction().begin();

            ref1= em.merge(ref1);
            ref2= em.merge(ref2);
            ref3= em.merge(ref3);

            ArbitragemEntity team = new ArbitragemEntity();
            team.setIdArbitragem(getNextAvailableId());
            if(ref1.getIdArbitro() == 0) {
                ref1.setIdArbitro(getNextAvailableId());
            }
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
=======

    public static void createRefTeam(ArbitragemEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(ref);
        em.getTransaction().commit();
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
    }

    public static void deleteRefTeam(ArbitragemEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(ref);
        em.getTransaction().commit();
    }

    public static ArbitragemEntity findRefTeam(int id){
        return DBConnection.getEntityManager().find(ArbitragemEntity.class,id);
    }

    public static List listRefTeam(){
        return DBConnection.getEntityManager().createQuery("from ArbitragemEntity ").getResultList();
    }
<<<<<<< HEAD
    /* Testar a inserção de uma equipa de arbitragem
    public static void testInsertion() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            ArbitroEntity ref1 = em.find(ArbitroEntity.class, 1); // Use um ID válido
            ArbitroEntity ref2 = em.find(ArbitroEntity.class, 2);
            ArbitroEntity ref3 = em.find(ArbitroEntity.class, 3);

            ArbitragemEntity team = new ArbitragemEntity();
            team.setArbitroByIdArbitro1(ref1);
            team.setArbitroByIdArbitro2(ref2);
            team.setArbitroByIdArbitro3(ref3);
            em.persist(team);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        System.out.println("Insertion successful");
    }
    */

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
=======

>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284

}