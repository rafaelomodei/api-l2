package com.example.l2velhaguarda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.l2velhaguarda.domain.GameCharacter;
import java.util.List;

public interface CharacterRepository extends JpaRepository<GameCharacter, Long> {
    List<GameCharacter> findByUserId(Long userId);
}
