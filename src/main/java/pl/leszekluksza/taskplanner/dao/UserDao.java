package pl.leszekluksza.taskplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.leszekluksza.taskplanner.model.User;
import pl.leszekluksza.taskplanner.repository.UserRepository;

@Component
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public String register(String login, String password){
        userRepository.save(new User(login,password));
        return "saved";
    }
}
