package com.f1dashboard.f1_standings.repository;

import com.f1dashboard.f1_standings.entities.Driver;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public interface DriverJpaRepository extends JpaRepository<Driver,Long> {

    List<Driver> findAllByOrderByNrPuncteDesc();
     Optional<Driver> findFirstByOrderByNrPuncteDesc();
    List<Driver> findTop3ByOrderByNrPuncteDesc();

    // 🏎️ 3. Drivers by team
    List<Driver> findByEchipa(String echipa);

    // 📈 4. Drivers sorted by wins
    List<Driver> findAllByOrderByNrVictoriiDesc();

    // 🔍 5. Minimum points
    List<Driver> findByNrPuncteGreaterThanEqual(long points);

    // 🏁 6. Team + minimum points
    List<Driver> findByEchipaAndNrPuncteGreaterThanEqual(String echipa, long points);

}
