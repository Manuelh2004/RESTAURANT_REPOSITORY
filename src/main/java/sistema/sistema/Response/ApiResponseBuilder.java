package sistema.sistema.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseBuilder {
     public static <T> ResponseEntity<ApiResponse<T>> buildResponse(
            HttpStatus status, String description, T data) {
        ApiResponse<T> response = new ApiResponse<>(
                status.value(),
                status.getReasonPhrase(),
                description,
                data
        );
        return new ResponseEntity<>(response, status);
    }
}
