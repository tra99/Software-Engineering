package SE.GIC.TP06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import SE.GIC.TP06.entity.MyUser;
import SE.GIC.TP06.repository.UserRepository;

import java.util.List; 
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<MyUser> getAllUsers() {
        return userRepository.findAll();
    }

    public MyUser signUp(MyUser myUser) {
        if (userRepository.findByUsername(myUser.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return userRepository.save(myUser);
    }

    public MyUser findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void updatePassword(String username, String newPassword) {
        MyUser myUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        myUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(myUser);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    public boolean signIn(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }
}
