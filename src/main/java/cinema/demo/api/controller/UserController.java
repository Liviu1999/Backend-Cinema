package cinema.demo.api.controller;

import cinema.demo.api.model.User;
import cinema.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        return (User) user.orElse(null);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String nickname = body.get("nickname");
        String password = body.get("password");

        if (nickname == null || email == null || password == null) {
            return ResponseEntity.badRequest().body("Invalid request, email or password are required!");
        }
        userService.saveUser(new User(nickname, email, password));

        return ResponseEntity.ok("User successfully registered");
    }
}
