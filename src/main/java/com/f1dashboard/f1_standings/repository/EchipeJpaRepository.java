package com.f1dashboard.f1_standings.repository;
import com.f1dashboard.f1_standings.entities.Echipa;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class EchipeJpaRepository {
    @PersistenceContext
    EntityManager entityManager;
    public List<Echipa> findAll(){
        TypedQuery<Echipa> query=entityManager.createQuery("from Echipe",Echipa.class);
        return query.getResultList();
    }
    public Echipa findById(int id){
        return entityManager.find(Echipa.class, id);
    }
    public void deleteById(int id){
        Echipa persoana=findById(id);
        entityManager.remove(persoana);
    }
    public Echipa insert(Echipa Echipa){
        return entityManager.merge(Echipa);
    }
    public Echipa update(Echipa persoana){
        return entityManager.merge(persoana);
    }
}

