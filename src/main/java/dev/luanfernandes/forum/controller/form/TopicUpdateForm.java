package dev.luanfernandes.forum.controller.form;

import com.sun.istack.NotNull;
import dev.luanfernandes.forum.model.Topic;
import dev.luanfernandes.forum.repository.TopicRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TopicUpdateForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String title;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String message;

    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
