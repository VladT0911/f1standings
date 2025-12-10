package com.f1dashboard.f1_standings.repository;

import com.f1dashboard.f1_standings.entities.Cursa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursaJpaRepository extends JpaRepository<Cursa, Long> {
    List<Cursa> findAllByOrderByDataCurseiAsc();
}
