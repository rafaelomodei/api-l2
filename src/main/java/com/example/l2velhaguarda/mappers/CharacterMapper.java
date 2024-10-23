package com.example.l2velhaguarda.mappers;

import com.example.l2velhaguarda.domain.GameCharacter;
import com.example.l2velhaguarda.dtos.CharacterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CharacterDTO toDTO(GameCharacter character) {
        return modelMapper.map(character, CharacterDTO.class);
    }

    public GameCharacter toEntity(CharacterDTO characterDTO) {
        return modelMapper.map(characterDTO, GameCharacter.class);
    }
}
