//package com.example.demoapi.controller.rest;
//
//import com.example.demoapi.config.jwt.JwtTokenProvider;
//import com.example.demoapi.dto.AuthenticationUserDto;
//import com.example.demoapi.entity.security.AccountUser;
//import com.example.demoapi.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping(value = "/api/v1/auth/")
//public class AuthenticationRestController {
//
//    private final UserService userService;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthenticationUserDto authenticationUserDto) {
//        try {
//            final String username = authenticationUserDto.getUsername();
//            AccountUser accountUser = userService.findByUsername(username);
//
//            String token = jwtTokenProvider.createToken(username, accountUser.getRoles());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("username", username);
//            response.put("token", token);
//
//            return ResponseEntity.ok(response);
//        } catch (UsernameNotFoundException e) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//}