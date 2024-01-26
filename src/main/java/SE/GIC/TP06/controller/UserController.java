package SE.GIC.TP06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import SE.GIC.TP06.entity.MyUser;
import SE.GIC.TP06.service.UserService;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody MyUser myUser) {
        try {
            userService.signUp(myUser);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyUser>> getAllUsers() {
        List<MyUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<MyUser> getUser(@PathVariable String username) {
        try {
            MyUser myUser = userService.findByUsername(username);
            return ResponseEntity.ok(myUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{username}/update-password")
    public ResponseEntity<String> updatePassword(
            @PathVariable String username,
            @RequestParam(name = "newPassword") String newPassword
    ) {
        try {
            userService.updatePassword(username, newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        try {
            userService.deleteByUsername(username);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestParam String username, @RequestParam String password) {
        if (userService.signIn(username, password)) {
            return ResponseEntity.ok("Sign-in successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}
