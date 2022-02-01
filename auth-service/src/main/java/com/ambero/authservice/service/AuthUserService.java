package com.ambero.authservice.service;

import com.ambero.authservice.dto.AuthUserDto;
import com.ambero.authservice.dto.TokenDto;
import com.ambero.authservice.entity.User;
import com.ambero.authservice.repository.UserRepository;
import com.ambero.authservice.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserRepository userRepository;

    public User save(AuthUserDto dto){
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if(user.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        User usuario = User.builder()
                .familyName(dto.getFamilyName())
                .givenName(dto.getGivenName())
                .email(dto.getEmail())
                .password(password)
                .build();

        return userRepository.save(usuario);
    }

    public TokenDto login(AuthUserDto dto) {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if(!user.isPresent())
            return null;
        if(passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }

    public TokenDto validate(String token) {
        if (jwtProvider.validate(token))
            return null;
        String email = jwtProvider.getUserEmailFromToken(token);
        if(!userRepository.findByEmail(email).isPresent())
            return null;
        return new TokenDto(token);
    }

}
