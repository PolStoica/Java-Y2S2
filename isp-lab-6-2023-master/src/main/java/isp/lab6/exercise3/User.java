package isp.lab6.exercise3;

import java.util.Objects;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean equals(Object user){
        if (user instanceof User){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(username);
    }
}
