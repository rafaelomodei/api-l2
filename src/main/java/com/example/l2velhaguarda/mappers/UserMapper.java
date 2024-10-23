package com.example.l2velhaguarda.mappers;

import com.example.l2velhaguarda.domain.User;
import com.example.l2velhaguarda.dtos.UserDTO;
import com.example.l2velhaguarda.dtos.UserRegistrationDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserRegistrationDTO userRegistrationDTO) {
        return modelMapper.map(userRegistrationDTO, User.class);
    }
}
