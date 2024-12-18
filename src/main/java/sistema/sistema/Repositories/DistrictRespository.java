package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.DistrictEntity;

@Repository
public interface DistrictRespository extends JpaRepository<DistrictEntity, Integer> {
    
}
