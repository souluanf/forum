CREATE DATABASE IF NOT EXISTS forum;


CREATE USER IF NOT EXISTS 'forum'@'localhost'IDENTIFIED WITH caching_sha2_password BY 'forum';
GRANT ALL ON forum.* TO 'forum'@'localhost';


INSERT INTO users(name, email, password)
VALUES ('Aluno', 'aluno@email.com', '123456');

INSERT INTO courses(name,category)
VALUES ('Spring Boot', 'Programação'),
       ('HTML 5', 'Front-end');

INSERT INTO topic(title, message, creation_date, status, author_id, course_id)
VALUES ('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1),
       ('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1),
       ('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);