package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.UserDto;
import nl.novi.backendwhattoeat.dtos.CreateUserDto;
import nl.novi.backendwhattoeat.models.User;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        final User newUser = new User();
        newUser.setUsername(createUserDto.getUsername());
        newUser.setPassword(createUserDto.getPassword());
        newUser.setEmailadress(createUserDto.getEmailadress());

        final User savedUser = userRepository.save(newUser);

        final UserDto userCreatedDto = new UserDto();
        userCreatedDto.setId(savedUser.getId());
        userCreatedDto.setUsername(savedUser.getUsername());

        return userCreatedDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            UserDto dto = transferToDto(user);
            userDtoList.add(dto);
        }
        return userDtoList;
    }

    public UserDto transferToDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }

    public List<UserDto> getAllUsersByUsername(String username) {
        List<User> userList = userRepository.findAllUsersByUsernameEqualsIgnoreCase(username);
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            UserDto dto = transferToDto(user);
            userDtoList.add(dto);
        }
        return userDtoList;
    }

    public UserDto getUserById(Long id) {
        return null;
    }

    public void deleteUser(Long id) {
    }

    public UserDto updateUser(Long id, CreateUserDto newUser) {
        return null;
    }
}