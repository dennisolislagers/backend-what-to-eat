package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.AuthenticationRequestDto;
import nl.novi.backendwhattoeat.security.JwtUtil;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<Object>signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto){

        UsernamePasswordAuthenticationToken up = new UsernamePasswordAuthenticationToken(
                authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());
        Authentication authentication  = authenticationManager.authenticate(up);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer" + token)
                .body(token);
    }
}
