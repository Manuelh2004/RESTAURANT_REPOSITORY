package sistema.sistema.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.sistema.Entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    @Query("SELECT u FROM UserEntity u WHERE u.usr_email = :usr_email")
    Optional<UserEntity> findByUsrEmail(@Param("usr_email") String usr_email);
}
