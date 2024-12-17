package sistema.sistema.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
    @Query("SELECT u FROM RoleEntity u WHERE u.rol_name = :rol_name")
    Optional<RoleEntity> findByRolName(@Param("rol_name") String rol_name);
}
