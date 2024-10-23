package com.example.l2velhaguarda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.l2velhaguarda.domain.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
