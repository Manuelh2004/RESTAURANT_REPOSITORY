package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.AttendanceRecordEntity;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Integer> {
    
}
