package com.f1dashboard.f1_standings.repository;
import com.f1dashboard.f1_standings.entities.Echipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EchipeJpaRepository extends JpaRepository<Echipa,Long> {
    List<Echipa> findAllByOrderByNrPuncteDesc();


}

