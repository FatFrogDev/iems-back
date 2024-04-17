package com.fatfrogdev.iemsbackend.config;

import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class IemsBackendUserDetails implements UserDetailsService{

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optUserEntity = userRepository.findByUsername(username);

        if(optUserEntity.isPresent()){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(optUserEntity.get().getRole().name()));

            return new User(optUserEntity.get().getEmail(),
                            optUserEntity.get().getPassword(),
                            authorities);
        }
        throw new UsernameNotFoundException(String.format("User with username %s not found", username));
    }
}
