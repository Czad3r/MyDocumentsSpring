package info.kowalczuk.spring.api.service;

public interface Login {
    public boolean isAuthorized(String email, String pass);
}
