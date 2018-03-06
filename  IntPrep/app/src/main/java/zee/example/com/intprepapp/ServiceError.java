package zee.example.com.intprepapp;

/**
 * Created by Zul Qarnain on 3/5/2018.
 */

class ServiceError {
    private Throwable errorObject;
    private String message;

    public ServiceError() {
        message = "";
    }

    public ServiceError(Throwable errorObject, String message) {
        this.errorObject = errorObject;
        this.message = message;
    }

    public Throwable getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(Throwable errorObject) {
        this.errorObject = errorObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
