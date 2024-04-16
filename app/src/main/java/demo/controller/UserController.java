package demo.controller;

import demo.Util.TokenUtils;
import demo.dto.AuthenticationRequest;
import demo.dto.UserTokenState;
import demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.dto.UserDTO;
import  demo.model.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;


    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;



    @PostMapping(value ="/register", consumes = "application/json")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO request){
        User existingUser = userService.findByEmail(request.getEmail());

        if(existingUser != null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new UserDTO(existingUser));
        }

        return ResponseEntity.ok(new UserDTO(userService.register(request)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserTokenState> authenticate(@RequestBody AuthenticationRequest request){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()

        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String jwt  = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }





}
