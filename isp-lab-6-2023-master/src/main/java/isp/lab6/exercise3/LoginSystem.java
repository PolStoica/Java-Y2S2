package isp.lab6.exercise3;

import java.util.LinkedHashSet;
import java.util.Set;

public class LoginSystem {
    private Set<User> users;
    private OnlineStore store;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public OnlineStore getStore() {
        return store;
    }

    public void setStore(OnlineStore store) {
        this.store = store;
    }

    public LoginSystem(OnlineStore store, Set<User> users) {
        this.store = store;
        this.users = users;
    }

    public LoginSystem() {
        this.store = new OnlineStore();
        this.users = new LinkedHashSet<User>();
    }

    //Methods implemented
    public void register(String username, String password) {
        boolean flag = false;
        for (User user : users) {
           if (user.getUsername().equals(username)){
               System.out.println("User already exists");
               flag=true;
           }
        }
         if (!flag){
            users.add(new User(username, password));
         }
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                users.add(user);
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("The username provided or the password is incorrect, or you may need to register");
        return false;
    }

    public void logout(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
            }
        }
            System.out.println("You cannot log out because you are not logged in");
    }
}
