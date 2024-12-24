package sistema.sistema.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import sistema.sistema.Entities.AttendanceEntity;
import sistema.sistema.Entities.AttendanceHistoryEntity;
import sistema.sistema.Entities.AttendanceRecordEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Repositories.AttendanceHistoryRepository;
import sistema.sistema.Repositories.AttendanceRecordRepository;
import sistema.sistema.Repositories.AttendanceRepository;

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

    //AttendanceRecord ********************************
    public List<AttendanceRecordEntity> getAllAttendanceRecord() {
        return attendanceRecordRepository.findAll(); 
    }

    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendance_record) {

        // Obtener el usuario logueado
        UserEntity user = authService.getLoggedInUserEntity();
        if (user == null) {
            throw new RuntimeException("No se pudo obtener el usuario logueado.");    
        }     

        // Obtener el día de la semana actual
        LocalDate currentDate = LocalDate.now();
        String dayOfWeek = currentDate.getDayOfWeek()
                                      .getDisplayName(TextStyle.FULL, Locale.getDefault()); // Ejemplo: "Monday" o "Lunes"

        // Obtener la hora actual
        LocalTime currentTime = LocalTime.now();
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")); // Formato: "HH:mm:ss"

        // Asignar el día de la semana al campo atre_schedule
        attendance_record.setAtre_schedule(dayOfWeek);
        attendance_record.setAtre_hour_entry(formattedTime);
        attendance_record.setUsers(user);
        return attendanceRecordRepository.save(attendance_record);
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
