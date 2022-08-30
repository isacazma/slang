package nl.hu.bep.battlesnake.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class MyUser implements Principal {
    private static List<MyUser> allUsers;

    static {
        allUsers = new ArrayList<>();
        allUsers.add(new MyUser("John", "London", "admin"));
    }

    private String name;
    private String pass;
    private String role;

    public MyUser(String name, String password, String role) {
        this.name = name;
        this.pass = password;
        this.role = role;
    }

    public static String validateLogin(String username, String password) {
        for (MyUser user : allUsers) {
            if (user.name.equals(username) && user.pass.equals(password)) {
                return user.role;
            }
        }
        return null;
    }

    public static MyUser getUserByName(String name) {
        for (MyUser user : allUsers) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public String getPass() {
        return pass;
    }

}
