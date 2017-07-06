package net.antra.hanz.service;

import net.antra.hanz.util.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Return True if user is not logged in.
 *
 * Created by hanzheng on 6/26/17.
 */
public class InvalidLoginStatusService extends AbstractService<Boolean> {

    private HttpServletRequest req;

    public InvalidLoginStatusService(HttpServletRequest req) {
        this.req = req;
    }

    public Boolean service(){
        User user = (User) req.getSession().getAttribute("user");
        return user==null;
    }
}
