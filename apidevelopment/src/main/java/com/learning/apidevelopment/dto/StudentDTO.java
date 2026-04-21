package com.learning.apidevelopment.dto;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentDTO {
    private Long id ;
    private String name;
    private String email;
}
