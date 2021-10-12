package models;

public class user {
    
    String username = null;
    String password = null;
    
    public user() {
        this.username = "";
        this.password = "";
    }
    
    public user(String uname, String upassword) {
        this.username = uname;
        this.password = upassword;
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

