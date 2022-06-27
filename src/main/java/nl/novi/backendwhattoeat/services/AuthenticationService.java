package nl.novi.backendwhattoeat.services;


import nl.novi.backendwhattoeat.dtos.AuthenticationRequestDto;
import nl.novi.backendwhattoeat.dtos.AuthenticationResponseDto;
import nl.novi.backendwhattoeat.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
//
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    JwtUtil jwtUtil;
//
//    public AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto) {
//
//
//        String username = authenticationRequestDto.getUsername();
//        String password = authenticationRequestDto.getPassword();
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//        } catch (BadCredentialsException ex) {
//            throw new UsernameNotFoundException("De gebruikersnaam of het wachtwoord is verkeerd");
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return new AuthenticationResponseDto(jwt);
//    }
}
