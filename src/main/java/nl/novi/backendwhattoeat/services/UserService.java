package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.Dtos.UserCreatedDto;
import nl.novi.backendwhattoeat.Dtos.CreateUserDto;
import nl.novi.backendwhattoeat.models.User;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCreatedDto createUser(CreateUserDto createUserDto) {
        final User newUser = new User();
        newUser.setUsername(createUserDto.getUsername());
        newUser.setPassword(createUserDto.getPassword());
        newUser.setEmailadress(createUserDto.getEmailadress());

        final User savedUser = userRepository.save(newUser);

        final UserCreatedDto userCreatedDto = new UserCreatedDto();
        userCreatedDto.setId(savedUser.getId());
        userCreatedDto.setUsername(savedUser.getUsername());

        return userCreatedDto;
    }


}
