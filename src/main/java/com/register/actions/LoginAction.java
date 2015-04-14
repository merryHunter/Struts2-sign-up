package com.register.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts2.interceptor.SessionAware;

import com.register.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Record new user into database.
 */
public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {

    private static final long serialVersionUID = -3369875299120377549L;

    private User user = new User();

    private Date dateBirthday;

    private Map<String, Object> sessionAttributes = null;

    public static Logger logger = Logger.getLogger(LoginAction.class);

    @Override
    public String execute() {
        user.setBirthday(new java.sql.Date(dateBirthday.getTime()));
        user.setId(new Date().getTime() / 1000000);
        //transfer data to interceptor
        sessionAttributes.put("USER", user);

        Connection conn = null;
        String sql;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                    "root", "root");
            Statement stm = conn.createStatement();

            logger.info("INSERT USER:");
            logger.info(user.toString());
            sql = "INSERT INTO  users(username, surname,phone,city,address, birthday)" +
                    "VALUES ( '" +
                    user.getName() + "', '" +
                    user.getSurname() + "', '" +
                    user.getPhone() + "', '" +
                    user.getCity() + "', '" +
                    user.getAddress() + "', '" +
                    user.getBirthday() + "');";
            stm.execute(sql);

            return SUCCESS;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return ERROR;
        } catch (NullPointerException e) {
            logger.error(e.getMessage());
            return ERROR;
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        return INPUT;
    }

    public void validate() {
        if (user.getName().equals(user.getSurname())) {
            logger.error("User tried to login using the same first and last name:");
            logger.error(user.getName());
            logger.error(user.getSurname());
            addFieldError("name", "The first and last name must not be the same.");
        }
        if (user.getName().equals("")) {
            addFieldError("name", "The name is required");
        }
        if (user.getPhone().length() < 5) {
            addFieldError("phone", "The phone length too less");
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    @Override
    public User getModel() {
        return user;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }
}
