package sistema.sistema.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Entities.ScheduleEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Repositories.ScheduleRepository;
import sistema.sistema.Repositories.UserRepository;

@Service
public class ScheduleService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScheduleRepository scheduleRepository; 
    @Autowired
    AuthService authService; 

    public List<ScheduleEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<ScheduleEntity> getScheduleById(int id) {
        return scheduleRepository.findById(id);
    }

    public ScheduleEntity createSchedule(ScheduleEntity schedule) {
       // Obtener el usuario logueado
       UserEntity user = authService.getLoggedInUserEntity();
       if (user == null) {
           throw new IllegalStateException("USER_NOT_FOUND");
       }
       // Verificar si el usuario ya tiene un horario
       Optional<ScheduleEntity> existingSchedule = scheduleRepository.findByUsuario(user);
       if (existingSchedule.isPresent()) {
           throw new IllegalStateException("SCHEDULE_ALREADY_EXISTS");
       }

       schedule.setUsuario(user);
       return scheduleRepository.save(schedule);
    }

    public ScheduleEntity updateSchedule(int id, ScheduleEntity scheduleDetails) {
        return scheduleRepository.findById(id).map(schedule -> {
            schedule.setShde_monday(scheduleDetails.getShde_monday());
            schedule.setShde_tuesday(scheduleDetails.getShde_tuesday());
            schedule.setShde_wednesday(scheduleDetails.getShde_wednesday());
            schedule.setShde_thursday(scheduleDetails.getShde_thursday());
            schedule.setShde_friday(scheduleDetails.getShde_friday());
            schedule.setShde_saturday(scheduleDetails.getShde_saturday());
            schedule.setShde_sunday(scheduleDetails.getShde_sunday());
            schedule.setShde_start_date(scheduleDetails.getShde_start_date());
            schedule.setShde_status(scheduleDetails.getShde_status());
            schedule.setShde_number_hours(scheduleDetails.getShde_number_hours());           
            return scheduleRepository.save(schedule);
        }).orElseThrow(() -> new RuntimeException("Schedule not found with id " + id));
    }    
}
