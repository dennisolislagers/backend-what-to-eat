package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.UserDto;
import nl.novi.backendwhattoeat.dtos.CreateUserDto;
import nl.novi.backendwhattoeat.exceptions.UserNotFoundException;
import nl.novi.backendwhattoeat.models.User;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
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

    public UserDto getUserById(Long id) {

        if (userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            return transferToDto(user);
        } else {
            throw new UserNotFoundException("geen gebruiker gevonden");
        }
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

//    public UserDto createUser(CreateUserDto createUserDto) {
//        try {
//            String encryptedPassword = passwordEncoder.encode(createUserDto.getPassword());
//
//            User user = new User();
//            user.setUsername(createUserDto.getUsername());
//            user.setPassword(createUserDto.getPassword());
//            user.setEmailadress(createUserDto.getEmailadress());
//            user.setEnabled(true);
//
//            User newUser = userRepository.save(user);
//            return newUser.getUsername();
//        } catch (Exception ex) {
//            throw new BadRequestException("Bad Request, kan gebruiker niet maken!!");
//        }
//    }

    public UserDto createUser(CreateUserDto dto) {
        User user = transferToUser(dto);
        userRepository.save(user);
        return transferToDto(user);
    }

    public void deleteUser(@RequestBody Long id) { userRepository.deleteById(id);
    }

    public UserDto updateUser(Long id, CreateUserDto newUser) {
        if (userRepository.findById(id).isPresent()){

            User user = userRepository.findById(id).get();

            User user1 = transferToUser(newUser);
            user1.setId(user.getId());

            userRepository.save(user1);

            return transferToDto(user1);

        } else {

            throw new UserNotFoundException("geen gebruiker gevonden");

        }
    }

    public UserDto transferToDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }

   public User transferToUser(CreateUserDto createUser) {
        var user = new User();

        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());
        user.setEmailadress(createUser.getEmailadress());

        return user;
    }









//    public Set<Authority> getAuthorities(String username) {
//        Optional<User> userOptional = userRepository.findById(username);
//        if (userOptional.isEmpty()) {
//            throw new UserNotFoundException(username);
//        } else {
//            User user = userOptional.get();
//            return user.getAuthorities();
//        }
//    }

//    public void addAuthority(String username, String authorityString) {
//        Optional<User> userOptional = userRepository.findById(username);
//        if (userOptional.isEmpty()) {
//            throw new UserNotFoundException(username);
//        } else {
//            User user = userOptional.get();
//            user.addAuthority(authorityString);
//            userRepository.save(user);
//        }
//    }

//    public void removeAuthority(String username, String authorityString) {
//        Optional<User> userOptional = userRepository.findById(username);
//        if (userOptional.isEmpty()) {
//            throw new UserNotFoundException(username);
//        } else {
//            User user = userOptional.get();
//            user.removeAuthority(authorityString);
//            userRepository.save(user);
//        }
//    }


}