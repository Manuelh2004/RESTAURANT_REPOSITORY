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
    //@Query("SELECT s FROM ScheduleEntity s HERE s.usr_id = :usr_id")
    //Optional<ScheduleEntity> findByUsuario(@Param("usr_id") Integer usr_id);
    Optional<ScheduleEntity> findByUsuario(UserEntity usuario);
}
