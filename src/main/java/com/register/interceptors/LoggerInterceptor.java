package com.register.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.register.models.User;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by Ivan on 14/04/2015.
 * <p/>
 * Log registred user.
 */
public class LoggerInterceptor implements Interceptor {

    public static final Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String actionResult = invocation.invoke();
        if (actionResult.equals(Action.ERROR)) {
            logger.error("Log in was unsuccessful.");
            return Action.ERROR;
        } else if (actionResult.equals(Action.INPUT)) {
            return Action.SUCCESS;
        }
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        User user = (User) session.get("USER");

        logger.info("User " + user.getId());
        logger.info("First name:\t " + user.getName());
        logger.info("Last name:\t " + user.getSurname());
        logger.info("Phone:\t " + user.getPhone());
        logger.info("Address:\t " + user.getAddress());
        logger.info("Birthday date:\t " + user.getBirthday());

        return Action.SUCCESS;
    }
}
