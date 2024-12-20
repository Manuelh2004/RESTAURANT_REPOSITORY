package sistema.sistema.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sistema.Entities.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {
    
}
