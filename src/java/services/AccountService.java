package services;

import models.User;

public class AccountService {
    
    public AccountService () {
    }
    
    public User login(String username, String password) {
        if (username.equals("abe") || username.equals("barb")) {
            if (password.equals("password")) {
                
                User returnUser = new User(username, null);
                return returnUser;
            }
            else {
                System.out.println("Failed Authentication");
                return null;
            }
        }
            else {
                    
                System.out.println("Failed Authentication");
                return null;
            }
                     
}
}

