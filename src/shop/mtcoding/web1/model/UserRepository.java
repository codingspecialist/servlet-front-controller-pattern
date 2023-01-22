package shop.mtcoding.web1.model;

import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private UserRepository(){}
    private static UserRepository userRepository = new UserRepository();
    public static UserRepository getInstance(){
        return userRepository;
    }

    public List<User> findAll(){
        // DB접근
        List<User> users = Arrays.asList(newUser(1), newUser(2), newUser(3));
        return users;
    }

    public User findById(int id){
        return newUser(id);
    }

    private User newUser(int id){
        User user = new User();
        user.setId(id);
        user.setUsername("username "+id);
        user.setUsername("password "+id);
        return user;
    }

}
