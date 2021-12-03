package br.com.test.gotomars.api.exceptions;

public class LandingException {
    private String message;

    public LandingException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
