package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.UserDto;
import nl.novi.backendwhattoeat.exceptions.*;
import nl.novi.backendwhattoeat.models.Authority;
import nl.novi.backendwhattoeat.models.User;
import nl.novi.backendwhattoeat.repositories.FavouriteRepository;
import nl.novi.backendwhattoeat.repositories.NewsletterRepository;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final NewsletterRepository newsletterRepository;
    private final FavouriteRepository favouriteRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       NewsletterRepository newsletterRepository,
                       FavouriteRepository favouriteRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.newsletterRepository = newsletterRepository;
        this.favouriteRepository = favouriteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            UserDto dto = transferToDto(user);
            userDtoList.add(dto);
        }
        return userDtoList;
    }

    public UserDto getUser(String username) {

        if (userRepository.findById(username).isPresent()){
            User user = userRepository.findById(username).get();
            return transferToDto(user);
        } else {
            throw new UserNotFoundException("geen gebruiker gevonden");
        }
    }

    public String createUser(UserDto userDto) {
        try {
            String encryptedPassword = passwordEncoder.encode(userDto.getPassword());

            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(userDto.getEmail());
            user.setEnabled(true);
            user.addAuthority("USER");

            User newUser = userRepository.save(user);
            return newUser.getUsername();
        } catch (Exception ex) {
            throw new BadRequestException("Bad Request, kan gebruiker niet maken!!");
        }
    }

    public void deleteUser(@RequestBody String username) { userRepository.deleteById(username);
    }

    public UserDto updateUser(String username, UserDto userDto) {

        if (userRepository.findById(username).isPresent()) {

            User user = userRepository.findById(username).get();
            User user1 = transferToUser(userDto);

            userRepository.save(user1);

            return transferToDto(user1);
        }else{
            throw new UserNotFoundException("niemand gevonden");
        }

    }

    public Set<Authority> getAuthorities(String username) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            User user = userOptional.get();
            return user.getAuthorities();
        }
    }

    public void addAuthority(String username, String authorityString) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            User user = userOptional.get();
            user.addAuthority(authorityString);
            userRepository.save(user);
        }
    }

    public void removeAuthority(String username, String authorityString) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            User user = userOptional.get();
            user.removeAuthority(authorityString);
            userRepository.save(user);
        }
    }

    private boolean isValidPassword(String password) {
        final int MIN_LENGTH = 4;
        final int MIN_DIGITS = 1;
        final int MIN_LOWER = 1;
        final int MIN_UPPER = 0;
        final int MIN_SPECIAL = 0;
        final String SPECIAL_CHARS = "@#$%&*!()+=-_";

        long countDigit = password.chars().filter(ch -> ch >= '0' && ch <= '9').count();
        long countLower = password.chars().filter(ch -> ch >= 'a' && ch <= 'z').count();
        long countUpper = password.chars().filter(ch -> ch >= 'A' && ch <= 'Z').count();
        long countSpecial = password.chars().filter(ch -> SPECIAL_CHARS.indexOf(ch) >= 0).count();

        boolean validPassword = true;
        if (password.length() < MIN_LENGTH) validPassword = false;
        if (countLower < MIN_LOWER) validPassword = false;
        if (countUpper < MIN_UPPER) validPassword = false;
        if (countDigit < MIN_DIGITS) validPassword = false;
        if (countSpecial < MIN_SPECIAL) validPassword = false;

        return validPassword;
    }

    public void setPassword(String username, String password) {
        if (username.equals(getCurrentUserName())) {
            if (isValidPassword(password)) {
                Optional<User> userOptional = userRepository.findById(username);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    user.setPassword(passwordEncoder.encode(password));
                    userRepository.save(user);
                } else {
                    throw new UserNotFoundException();
                }
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new NotAuthorizedException();
        }
    }

    public void assignNewsletterToUser(String username,  Long newsletterId){
        var optionalUser = userRepository.findById(username);
        var optionalNewsletter = newsletterRepository.findById(newsletterId);


        if(optionalUser.isPresent() && optionalNewsletter.isPresent()) {
            var user = optionalUser.get();
            var newsletter = optionalNewsletter.get();

            newsletter.setUser(user);
            newsletterRepository.save(newsletter);
        } else {
            throw new RecordNotFoundException();
        }
    }
    public void assignFavouriteToUser(String username, Long favouriteId) {
        var optionalFavourite = favouriteRepository.findById(favouriteId);
        var optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent() && optionalFavourite.isPresent()){
            var user = optionalUser.get();
            var favourite = optionalFavourite.get();

            favourite.setUser(user);
            favouriteRepository.save(favourite);
        }
        else{
            throw new RecordNotFoundException();
        }
    }

    public UserDto transferToDto(User user) {
        UserDto dto = new UserDto();

        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setAuthorities(user.getAuthorities());

        return dto;
    }

   public User transferToUser(UserDto dto) {
        var user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setAuthorities(dto.getAuthorities());

        return user;
    }
}