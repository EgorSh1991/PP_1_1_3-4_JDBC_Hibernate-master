package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Donald", "Tramp", (byte) 60);
        userService.saveUser("Ivan", "Ivanov", (byte) 16);
        userService.saveUser("Test", "Testov", (byte) 23);
        userService.saveUser("Tramp", "Donald", (byte) 65);
        userService.removeUserById(4);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}