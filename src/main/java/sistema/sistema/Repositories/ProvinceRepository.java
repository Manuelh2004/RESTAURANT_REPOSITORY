package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.ProvinceEntity;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {
    
}
