package net.antra.hanz.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Return the E object if the service executes successfully, else returns null
 *
 * Created by hanzheng on 6/26/17.
 */
public abstract class AbstractService<E> {

    public abstract E service();
}
