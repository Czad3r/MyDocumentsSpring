package info.kowalczuk.spring.impl.service;

import info.kowalczuk.spring.api.service.Login;

public class LoginImpl implements Login {
    private String username;
    private String password;
    @Override
    public boolean isAuthorized(String email, String pass) {
        if(username.equals(email) && password.equals(pass))
            return true;
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
