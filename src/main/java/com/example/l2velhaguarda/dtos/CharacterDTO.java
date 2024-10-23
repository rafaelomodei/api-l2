package com.example.l2velhaguarda.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private Long id;
    private String name;
    private int level;
    private String classType;
}
