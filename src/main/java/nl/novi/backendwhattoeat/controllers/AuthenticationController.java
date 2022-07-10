package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.AuthenticationRequestDto;
import nl.novi.backendwhattoeat.dtos.AuthenticationResponseDto;
import nl.novi.backendwhattoeat.services.AuthenticationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController (AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<Object>signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto){

        AuthenticationResponseDto authenticationResponseDto = authenticationService.authenticateUser(authenticationRequestDto);

        return ResponseEntity.ok(authenticationResponseDto);
    }
}
