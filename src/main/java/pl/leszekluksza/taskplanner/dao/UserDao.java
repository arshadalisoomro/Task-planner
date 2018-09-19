package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.UserRepository;

import java.security.Principal;

@Component
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public String register(String login, String password){
        userRepository.save(new User(login,password));
        return "saved";
    }

    public User findUserByPrincipal(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return user;
    }
}
