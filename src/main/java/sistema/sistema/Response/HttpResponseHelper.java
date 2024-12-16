package sistema.sistema.Response;

import org.springframework.http.ResponseEntity;

public class HttpResponseHelper {
    private int statusCode;
    private String statusMessage;
    private String description;
    private Object data;
    private Object errorBag;

    public static HttpResponseHelper create() {
        return new HttpResponseHelper();
    }

    public HttpResponseHelper setStatus(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseHelper setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public HttpResponseHelper setDescription(String description) {
        this.description = description;
        return this;
    }

    public HttpResponseHelper setData(Object data) {
        this.data = data;
        return this;
    }

    public HttpResponseHelper setErrorBag(Object errorBag) {
        this.errorBag = errorBag;
        return this;
    }

    public ResponseEntity<Object> send() {
        return ResponseEntity.status(statusCode).body(this);
    }

    // Métodos predefinidos para respuestas comunes
    public ResponseEntity<Object> successfulResponse(String description, Object data) {
        return this.setStatus(HttpCodesHelper.OK)
                   .setStatusMessage("OK")
                   .setDescription(description)
                   .setData(data)
                   .send();
    }

    public ResponseEntity<Object> notFoundResponse(String description) {
        return this.setStatus(HttpCodesHelper.NOT_FOUND)
                   .setStatusMessage("Not Found")
                   .setDescription(description)
                   .send();
    }

    public ResponseEntity<Object> internalErrorResponse(String description) {
        return this.setStatus(HttpCodesHelper.INTERNAL_SERVER_ERROR)
                   .setStatusMessage("Internal Server Error")
                   .setDescription(description)
                   .send();
    }

    public ResponseEntity<Object> validationErrorResponse(String description, Object errorBag) {
        return this.setStatus(HttpCodesHelper.UNPROCESSABLE_ENTITY)
                   .setStatusMessage("Unprocessable Entity")
                   .setDescription(description)
                   .setErrorBag(errorBag)
                   .send();
    }

    public ResponseEntity<Object> forbiddenResponse(String description) {
        return this.setStatus(HttpCodesHelper.FORBIDDEN)
                   .setStatusMessage("Forbidden")
                   .setDescription(description)
                   .send();
    }
}
