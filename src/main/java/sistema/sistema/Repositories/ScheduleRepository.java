package sistema.sistema.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.ScheduleEntity;
import sistema.sistema.Entities.UserEntity;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer>{
    
    Optional<ScheduleEntity> findByUsuario(UserEntity usuario);

    @Query("SELECT s FROM ScheduleEntity s WHERE s.usuario = :user AND s.shde_status = 'Active'")
    Optional<ScheduleEntity> findActiveScheduleByUser(@Param("user") UserEntity user);
}
