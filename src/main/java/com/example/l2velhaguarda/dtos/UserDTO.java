package com.example.l2velhaguarda.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    // Não inclua o password aqui
}
