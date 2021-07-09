package dev.luanfernandes.forum.controller.dto;

import dev.luanfernandes.forum.model.Topic;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicsDto {
    private final Long id;
    private final String title;
    private final String message;
    private final LocalDateTime creationDate;

    public TopicsDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
    }

    public static List<TopicsDto> converter(List<Topic> topics) {
        return topics.stream().map(TopicsDto::new).collect(Collectors.toList());
    }
}
