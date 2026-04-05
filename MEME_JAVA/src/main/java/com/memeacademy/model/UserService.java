package com.memeacademy.model;

import java.util.ArrayList;

public class UserService {
    private final ArrayList<User> users = new ArrayList<>();
    public void addUser(User user) {
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }
}
