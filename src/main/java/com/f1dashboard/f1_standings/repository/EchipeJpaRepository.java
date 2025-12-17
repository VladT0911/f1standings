package com.f1dashboard.f1_standings.repository;

import com.f1dashboard.f1_standings.entities.Echipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchipeJpaRepository extends JpaRepository<Echipa, Long> {

    List<Echipa> findAllByOrderByNrPuncteDesc();

    List<Echipa> findByPowerunitIgnoreCase(String powerunit);

    List<Echipa> findAllByOrderByTeamPrincipalAsc();

    List<Echipa> findByPowerunitIgnoreCaseOrderByTeamPrincipalAsc(String powerunit);
}
