package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
    
}
