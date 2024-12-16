package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sistema.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
