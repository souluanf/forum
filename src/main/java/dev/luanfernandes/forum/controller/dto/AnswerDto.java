package dev.luanfernandes.forum.controller.dto;

import dev.luanfernandes.forum.model.Answer;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AnswerDto {
    private final Long id;
    private final String message;
    private final LocalDateTime creationDate;
    private final String authorName;


    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.authorName = answer.getAuthor().getName();
    }
}
