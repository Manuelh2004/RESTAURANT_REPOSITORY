package sistema.sistema.Controllers.Attendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.sistema.Entities.AttendanceEntity;
import sistema.sistema.Entities.AttendanceRecordEntity;
import sistema.sistema.Entities.BranchEntity;
import sistema.sistema.Entities.ScheduleEntity;
import sistema.sistema.Response.ApiResponse;
import sistema.sistema.Response.ApiResponseBuilder;
import sistema.sistema.Services.AttendanceService;

@RestController
@RequestMapping("/attendance_record")
public class AttendanceRecordController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendanceRecordEntity>>> getAllAttendanceRecord() {
        List<AttendanceRecordEntity> attendance_record = attendanceService.getAllAttendanceRecord();
        return ApiResponseBuilder.buildResponse(
                HttpStatus.OK,
                "Lista de attendance_record obtenida correctamente",
                attendance_record
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendanceRecordEntity>> createAttendanceRecord(@RequestBody AttendanceRecordEntity attendance_record) {
        AttendanceRecordEntity attendance_record_value = attendanceService.createAttendanceRecord(attendance_record);
        return ApiResponseBuilder.buildResponse(
                HttpStatus.CREATED,
                "Attendance record creada correctamente",
                attendance_record_value
        );
    }


}
