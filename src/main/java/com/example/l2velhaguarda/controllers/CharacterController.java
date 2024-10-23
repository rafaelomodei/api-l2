package com.example.l2velhaguarda.controllers;

import com.example.l2velhaguarda.services.CharacterService;
import com.example.l2velhaguarda.mappers.CharacterMapper;
import com.example.l2velhaguarda.dtos.CharacterDTO;
import com.example.l2velhaguarda.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterMapper characterMapper;

    @PostMapping("/create")
    public CharacterDTO createCharacter(@RequestBody CharacterDTO characterDTO, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        var character = characterMapper.toEntity(characterDTO);
        character.setUser(user);
        var savedCharacter = characterService.createCharacter(character);
        return characterMapper.toDTO(savedCharacter);
    }

    @GetMapping
    public List<CharacterDTO> getUserCharacters(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        var characters = characterService.getCharactersByUserId(user.getId());
        return characters.stream()
            .map(characterMapper::toDTO)
            .collect(Collectors.toList());
    }
}
