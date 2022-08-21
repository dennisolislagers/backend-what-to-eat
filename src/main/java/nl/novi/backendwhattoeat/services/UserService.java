package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.UserDto;
import nl.novi.backendwhattoeat.exceptions.*;
import nl.novi.backendwhattoeat.models.Authority;
import nl.novi.backendwhattoeat.models.User;
import nl.novi.backendwhattoeat.repositories.FavouriteRepository;
import nl.novi.backendwhattoeat.repositories.NewsletterRepository;
import nl.novi.backendwhattoeat.repositories.UserRepository;
import nl.novi.backendwhattoeat.security.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final NewsletterRepository newsletterRepository;
    private final FavouriteRepository favouriteRepository;


    public UserService(UserRepository userRepository,
                       NewsletterRepository newsletterRepository,
                       FavouriteRepository favouriteRepository) {

        this.userRepository = userRepository;
        this.newsletterRepository = newsletterRepository;
        this.favouriteRepository = favouriteRepository;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UserNotFoundException("geen gebruiker gevonden met: " + username);
        }
        return dto;
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(@RequestBody String username) { userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException("geen gebruiker gevonden");
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException("geen gebruiker gevonden met: " + username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UserNotFoundException("geen gebruiker gevonden met: " + username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException("geen gebruiker gevonden met: " + username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public static UserDto fromUser(User user){

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());

        return user;
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


}