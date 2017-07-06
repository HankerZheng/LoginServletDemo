package net.antra.hanz.util;


/**
 * Created by hanzheng on 6/24/17.
 */

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
}
