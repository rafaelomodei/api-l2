package com.example.l2velhaguarda.services;

import com.example.l2velhaguarda.domain.User;
import com.example.l2velhaguarda.repositories.UserRepository;
import com.example.l2velhaguarda.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado com o username : " + username)
            );

        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Usuário", "id", id)
            );

        return new CustomUserDetails(user);
    }
}
