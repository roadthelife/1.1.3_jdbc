package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {

    private static final UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("user1a", "userA", (byte) 10);
        userService.saveUser("user2b", "userB", (byte) 15);
        userService.saveUser("user3c", "userC", (byte) 20);
        userService.saveUser("user4dd", "userD", (byte) 25);

        List<User> users = userService.getAllUsers();
        for (User us : users) {
            System.out.println(us);
        }
        
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeConnect();
    }
}
