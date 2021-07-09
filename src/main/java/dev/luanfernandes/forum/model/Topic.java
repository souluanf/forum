package dev.luanfernandes.forum.model;

import dev.luanfernandes.forum.model.enums.TopicStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;
	private final LocalDateTime creationDate = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private TopicStatus status = TopicStatus.NAO_RESPONDIDO;

	@ManyToOne
	private User author;

	@ManyToOne
	private Course course;

	@OneToMany(mappedBy = "topic")
	private List<Answer> answers = new ArrayList<>();

	public Topic(String title, String message, Course course) {
		this.title = title;
		this.message = message;
		this.course = course;
	}
}
