package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.TypeClientEntity;

@Repository
public interface TypeClientRepository extends JpaRepository<TypeClientEntity, Integer> {
    
}
