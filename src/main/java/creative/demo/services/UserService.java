package creative.demo.services;

import creative.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import creative.demo.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
@RestController
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @GetMapping("/hello")
    public void sayHello()
    {
        System.out.println("Hello World");
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        List<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping(path = "/createUser")
    public ResponseEntity registerUser(@RequestBody User user) throws Exception {
        HashMap<String,Object> resp = new HashMap<>();
        System.out.printf("User: ", user);
        userRepository.save(user);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
