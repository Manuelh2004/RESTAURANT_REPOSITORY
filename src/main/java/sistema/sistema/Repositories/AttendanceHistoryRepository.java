package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.AttendanceHistoryEntity;

@Repository
public interface AttendanceHistoryRepository extends JpaRepository<AttendanceHistoryEntity, Integer> {
    
}
