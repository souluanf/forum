package dev.luanfernandes.forum.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;

	@ManyToOne
	private Topic topic;

	private LocalDateTime creationDate = LocalDateTime.now();

	@ManyToOne
	private User author;
	private Boolean solution = false;

}
