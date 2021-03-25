package org.vargassi.angular.sample;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    
    private List<User> users = new ArrayList<>();
    
    public UserRepository() {
        users.add(new User("Alex", "alex@gmail.com"));
        users.add(new User("Bob", "bob@gmail.com"));
        users.add(new User("Cathy", "cathy@yahoo.com"));
    }
    
    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }
    
}