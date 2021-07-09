package dev.luanfernandes.forum.controller.dto;

import dev.luanfernandes.forum.model.Topic;
import dev.luanfernandes.forum.model.enums.TopicStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicsDetailDto {
    private final Long id;
    private final String title;
    private final String message;
    private final LocalDateTime creationDate;
    private final String authorName;
    private final TopicStatus topicStatus;
    private final List<AnswerDto> answers;

    public TopicsDetailDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.authorName = topic.getAuthor().getName();
        this.topicStatus = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }

}
