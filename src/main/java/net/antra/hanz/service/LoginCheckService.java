package net.antra.hanz.service;


import net.antra.hanz.model.User;

import java.util.HashMap;

/**
 * Created by hanzheng on 6/23/17.
 */
public class LoginCheckService extends AbstractService<User> {

    static public HashMap<String, String> userAuthen = new HashMap();
    static {
        userAuthen.put("admin", "admin");
        userAuthen.put("hanzheng", "hz");
        userAuthen.put("guest", "antra");
    }

    private String username;
    private String password;

    public LoginCheckService(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public User service() {
        if (password.equals(userAuthen.get(username))) {
            return new User(username, password);
        } else {
            return null;
        }
    }
}
