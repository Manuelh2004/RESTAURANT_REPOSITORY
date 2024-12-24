package sistema.sistema.Repositories;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.AttendanceRecordEntity;
import sistema.sistema.Entities.UserEntity;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Integer> {
    @Query("SELECT a FROM AttendanceRecordEntity a WHERE a.atre_date = :date AND a.users = :user")
    Optional<AttendanceRecordEntity> findByAtreDateAndUser(@Param("date") LocalDate date, @Param("user") UserEntity user);
}
    
