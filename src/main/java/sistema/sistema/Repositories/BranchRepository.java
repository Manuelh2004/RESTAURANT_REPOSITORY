package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sistema.Entities.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
    
}
