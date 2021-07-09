package dev.luanfernandes.forum.controller;

import dev.luanfernandes.forum.controller.dto.TopicsDetailDto;
import dev.luanfernandes.forum.controller.dto.TopicsDto;
import dev.luanfernandes.forum.controller.form.TopicForm;
import dev.luanfernandes.forum.controller.form.TopicUpdateForm;
import dev.luanfernandes.forum.model.Topic;
import dev.luanfernandes.forum.repository.CourseRepository;
import dev.luanfernandes.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public TopicsController(TopicRepository topicRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<TopicsDto> list(String courseName) {
        List<Topic> topics;
        if (courseName == null) {
            topics = topicRepository.findAll();
            return TopicsDto.converter(topics);
        } else {
            topics = topicRepository.findByCourseName(courseName);
        }
        return TopicsDto.converter(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detail(@PathVariable Long id){
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.<ResponseEntity<Object>>map(value -> ResponseEntity.ok(
                new TopicsDetailDto(value))).orElseGet(() -> ResponseEntity.notFound().build()
        );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicsDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.converter(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicsDto(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicsDto> update(@PathVariable Long id, @RequestBody @Valid TopicUpdateForm form) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()){
            Topic topic = form.update(id,topicRepository);
            return ResponseEntity.ok(new TopicsDto(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()){
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
