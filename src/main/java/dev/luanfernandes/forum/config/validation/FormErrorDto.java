package dev.luanfernandes.forum.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FormErrorDto {
    private String field;
    private String message;
}
