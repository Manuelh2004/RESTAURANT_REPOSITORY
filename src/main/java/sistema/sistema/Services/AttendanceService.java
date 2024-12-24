package sistema.sistema.Services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Entities.AttendanceEntity;
import sistema.sistema.Entities.AttendanceHistoryEntity;
import sistema.sistema.Entities.AttendanceRecordEntity;
import sistema.sistema.Entities.ScheduleEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Repositories.AttendanceHistoryRepository;
import sistema.sistema.Repositories.AttendanceRecordRepository;
import sistema.sistema.Repositories.AttendanceRepository;
import sistema.sistema.Repositories.ScheduleRepository;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRecordRepository attendanceRecordRepository; 
    @Autowired
    AttendanceRepository attendanceRepository; 
    @Autowired
    AttendanceHistoryRepository attendanceHistoryRepository; 
    @Autowired
    AuthService authService; 
    @Autowired
    ScheduleRepository scheduleRepository; 

    //AttendanceRecord ********************************
    public List<AttendanceRecordEntity> getAllAttendanceRecord() {
        return attendanceRecordRepository.findAll(); 
    }

    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendance_record) {
        UserEntity user = Optional.ofNullable(authService.getLoggedInUserEntity())
        .orElseThrow(() -> new RuntimeException("No se pudo obtener el usuario logueado."));

        ScheduleEntity schedule = scheduleRepository.findActiveScheduleByUser(user)
            .orElseThrow(() -> new RuntimeException("No tienes un horario activo asignado."));

        LocalDate currentDate = LocalDate.now();
        String currentDayOfWeek = currentDate.getDayOfWeek()
                                            .getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                                            .toLowerCase();

        String scheduledHours = getScheduledHours(schedule, currentDayOfWeek);
        if (scheduledHours.isBlank()) {
            throw new RuntimeException("No tienes un horario disponible para hoy.");
        }

        LocalTime[] hours = parseHours(scheduledHours);
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(hours[0]) || currentTime.isAfter(hours[1])) {
            throw new RuntimeException("La hora actual no está dentro de tu horario disponible.");
        }

        if (attendanceRecordRepository.findByAtreDateAndUser(currentDate, user).isPresent()) {
            throw new RuntimeException("Ya has registrado tu asistencia para el día de hoy.");
        }

        attendance_record.setAtre_schedule(currentDayOfWeek);
        attendance_record.setAtre_hour_entry(currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        attendance_record.setAtre_date(currentDate);
        attendance_record.setUsers(user);
         // Calcular horas hechas desde el ingreso
        double hoursDone = calculateHoursDone(currentTime, hours[1]);
        attendance_record.setAtre_hours_done(hoursDone);

        return attendanceRecordRepository.save(attendance_record);
    }

    private double calculateHoursDone(LocalTime entryTime, LocalTime endTime) {
        long minutesDone = Duration.between(entryTime, endTime).toMinutes();
        return minutesDone / 60.0; // Convertir a horas
    }

    private String getScheduledHours(ScheduleEntity schedule, String dayOfWeek) {
        return switch (dayOfWeek) {
            case "monday" -> schedule.getShde_monday();
            case "tuesday" -> schedule.getShde_tuesday();
            case "wednesday" -> schedule.getShde_wednesday();
            case "thursday" -> schedule.getShde_thursday();
            case "friday" -> schedule.getShde_friday();
            case "saturday" -> schedule.getShde_saturday();
            case "sunday" -> schedule.getShde_sunday();
            default -> throw new RuntimeException("Día inválido.");
        };
    }
    
    private LocalTime[] parseHours(String scheduledHours) {
        String[] hoursRange = scheduledHours.split("-");
        if (hoursRange.length != 2) {
            throw new RuntimeException("Formato de horario inválido.");
        }
    
        String[] validPatterns = {"HH:mm", "H:mm"};
        LocalTime startTime = parseTime(hoursRange[0], validPatterns);
        LocalTime endTime = parseTime(hoursRange[1], validPatterns);
    
        if (startTime == null || endTime == null) {
            throw new RuntimeException("El formato del horario no es válido. Usa un formato como '10:00-12:00'.");
        }
    
        return new LocalTime[]{startTime, endTime};
    }
    
    private LocalTime parseTime(String timeString, String[] patterns) {
        for (String pattern : patterns) {
            try {
                return LocalTime.parse(timeString, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }



    
    //Attendance **************************************
    public List<AttendanceEntity> getAllAttendance() {
        return attendanceRepository.findAll(); 
    }

    //AttendanceHistory *******************************
    public List<AttendanceHistoryEntity> getAllAttendanceHistory() {
        return attendanceHistoryRepository.findAll(); 
    }

}
