package sistema.sistema.Controllers.Schedule;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.sistema.Entities.ScheduleEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Response.ApiResponse;
import sistema.sistema.Response.ApiResponseBuilder;
import sistema.sistema.Services.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    ScheduleService scheduleService; 

    @GetMapping
    public ResponseEntity<ApiResponse<List<ScheduleEntity>>> getAllBranches() {
        List<ScheduleEntity> schedules = scheduleService.getAllSchedules();
        return ApiResponseBuilder.buildResponse(
                HttpStatus.OK,
                "Lista de sucursales obtenida correctamente",
                schedules
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ScheduleEntity>> getBranchById(@PathVariable int id) {
        Optional<ScheduleEntity> schedule = scheduleService.getScheduleById(id);
        return schedule.map(b -> ApiResponseBuilder.buildResponse(
                        HttpStatus.OK,
                        "Horario obtenido correctamente",
                        b
                ))
                .orElseGet(() -> ApiResponseBuilder.buildResponse(
                        HttpStatus.NOT_FOUND,
                        "Horario no encontrado",
                        null
                ));
    }

    @PostMapping
    public ScheduleEntity registrar(@RequestBody ScheduleEntity Sucursal){
        return scheduleService.createSchedule(Sucursal); 
    }



    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ScheduleEntity>> updateBranch(@PathVariable int id, @RequestBody ScheduleEntity scheduleDetails) {
        try {
            ScheduleEntity updatedSchedule = scheduleService.updateSchedule(id, scheduleDetails);
            return ApiResponseBuilder.buildResponse(
                    HttpStatus.OK,
                    "Horario actualizada correctamente",
                    updatedSchedule
            );
        } catch (RuntimeException e) {
            return ApiResponseBuilder.buildResponse(
                    HttpStatus.NOT_FOUND,
                    "Horario no encontrada para actualizar",
                    null
            );
        }
    }
}
