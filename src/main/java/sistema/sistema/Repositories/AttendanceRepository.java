package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {
    
}
