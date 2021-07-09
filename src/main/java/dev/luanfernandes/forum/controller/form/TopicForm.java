package dev.luanfernandes.forum.controller.form;

import com.sun.istack.NotNull;
import dev.luanfernandes.forum.model.Course;
import dev.luanfernandes.forum.model.Topic;
import dev.luanfernandes.forum.repository.CourseRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;
    @NotNull @NotEmpty @Length(min = 10)
    private String message;
    @NotNull @NotEmpty
    private String courseName;

    public Topic converter(CourseRepository courseRepository) {
        Course course = courseRepository.findByName(courseName);
        return new Topic(title,message,course);
    }
}
