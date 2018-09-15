package pl.leszekluksza.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.leszekluksza.taskplanner.dao.UserDao;

@RestController
@RequestMapping("api/User")
public class UserRestController {

    @Autowired
    UserDao userDao;

    @PostMapping("/register")
    public String register(@RequestParam String login, @RequestParam String password){
        return userDao.register(login, password);
    }
}
