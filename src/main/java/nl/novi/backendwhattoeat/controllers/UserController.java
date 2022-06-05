package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.Dtos.UserCreatedDto;
import nl.novi.backendwhattoeat.Dtos.CreateUserDto;
import nl.novi.backendwhattoeat.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreatedDto> createUser(@RequestBody CreateUserDto createUserDto){

        final UserCreatedDto user = userService.createUser(createUserDto);

        final URI location = URI.create("/users/" + user.getId());
        return ResponseEntity.created(location).body(user);

    }
}
