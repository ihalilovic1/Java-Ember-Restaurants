package helpers;

public class ErrorResponse {
    String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static ErrorResponse error(String error) {
        return new ErrorResponse(error);
    }
}
