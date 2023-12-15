package vttp2023.batch3.ssf.frontcontroller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    
    @NotBlank(message="username is required")
    @Size(min=2, message ="Min 2 characters")
    private String username;

    @NotBlank(message="password is required")
    @Size(min=2, message ="Min 2 characters")
    private String password;

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

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
