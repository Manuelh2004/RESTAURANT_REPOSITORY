package sistema.sistema.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Entities.AttendanceEntity;
import sistema.sistema.Entities.AttendanceHistoryEntity;
import sistema.sistema.Entities.AttendanceRecordEntity;
import sistema.sistema.Entities.BranchEntity;
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

    //AttendanceRecord ********************************
    public List<AttendanceRecordEntity> getAllAttendanceRecord() {
        return attendanceRecordRepository.findAll(); 
    }

    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendance_record) {
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
