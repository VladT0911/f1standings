package com.f1dashboard.f1_standings.repository;

import com.f1dashboard.f1_standings.entities.Cursa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional

public interface CursaJpaRepository extends JpaRepository<Cursa,Long> {
    List<Cursa> findAllByOrderByData_CurseiAsc();

}
