package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.DepartamentEntity;

@Repository
public interface DepartamentRepository extends JpaRepository<DepartamentEntity, Integer> {
    
}
