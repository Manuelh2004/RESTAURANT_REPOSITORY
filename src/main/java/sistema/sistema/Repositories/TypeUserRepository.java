package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sistema.Entities.TypeUserEntity;

public interface TypeUserRepository extends JpaRepository<TypeUserEntity, Integer> {
    
}
