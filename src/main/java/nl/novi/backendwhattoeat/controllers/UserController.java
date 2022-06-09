package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.UserDto;
import nl.novi.backendwhattoeat.dtos.CreateUserDto;
import nl.novi.backendwhattoeat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(value = "username", required = false) Optional<String> username) {

        List<UserDto> dtos;

        if (username.isEmpty()){

            dtos = userService.getAllUsers();

        } else {

            dtos = userService.getAllUsersByUsername (username.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {

        UserDto user = userService.getUserById(id);

        return ResponseEntity.ok().body(user);

    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){

        final UserDto user = userService.createUser(createUserDto);

        final URI location = URI.create("/users/" + user.getId());
        return ResponseEntity.created(location).body(user);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();

    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody CreateUserDto newUser) {

        UserDto dto = userService.updateUser(id, newUser);

        return ResponseEntity.ok().body(dto);
    }
    }

