package com.example.l2velhaguarda.services;

import com.example.l2velhaguarda.domain.GameCharacter;
import com.example.l2velhaguarda.repositories.CharacterRepository;
import com.example.l2velhaguarda.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public GameCharacter createCharacter(GameCharacter character) {
        return characterRepository.save(character);
    }

    public GameCharacter getCharacterById(Long id) {
        return characterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado"));
    }

    public List<GameCharacter> getCharactersByUserId(Long userId) {
        return characterRepository.findByUserId(userId);
    }

    // Outros métodos (update, delete)
}
