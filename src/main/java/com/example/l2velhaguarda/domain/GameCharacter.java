package com.example.l2velhaguarda.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCharacter {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int level;
    private String classType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
