
package com.example.session13.controller;

import com.example.session13.entity.User;
import com.example.session13.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/test")
    public String test() {
        return "Auth API is working!";
    }

    @PostMapping("/encode")
    public Map<String, String> encode(
            @RequestBody Map<String, String> request) {

        String rawPassword = request.get("password");

        return Map.of(
                "encodedPassword",
                passwordEncoder.encode(rawPassword)
        );
    }

    @PostMapping("/register-test")
    public String registerTest(@RequestBody Map<String, String> request) {

        User user = new User();
        user.setUsername(request.get("username"));
        user.setPassword(passwordEncoder.encode(request.get("password")));
        user.setRole(request.getOrDefault("role", "USER"));
        user.setEnabled(true);

        userRepository.save(user);

        return "Tạo tài khoản thành công!";
    }
}
