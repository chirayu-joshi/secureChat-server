CREATE SCHEMA secure_chat;

USE secure_chat;

CREATE TABLE users(
	uid INT AUTO_INCREMENT PRIMARY KEY, 
    firstname VARCHAR(30) NOT NULL, 
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    passwd VARCHAR(100) NOT NULL
);

DESC users;

INSERT INTO users (`firstname`, `lastname`, `email`, `passwd`) VALUES ('Chirayu', 'Joshi', 'chirayu@gmail.com', 'abcd1234');
INSERT INTO users (`firstname`, `lastname`, `email`, `passwd`) VALUES ('Dhyey', 'Desai', 'dhyey@gmail.com', 'abcd1234');
INSERT INTO users (`firstname`, `lastname`, `email`, `passwd`) VALUES ('Abhi', 'Joshi', 'abhi@gmail.com', 'abcd1234');

SELECT * FROM users;
SELECT * FROM users WHERE email='chirayu@gmail.com' AND passwd='abcd1234';

DELETE FROM users;

DROP TABLE users;

CREATE TABLE chats (
	id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    message VARCHAR(150)
);

INSERT INTO chats (`sender_id`, `receiver_id`, `message`) VALUES (1, 2, 'hii');
INSERT INTO chats (`sender_id`, `receiver_id`, `message`) VALUES (2, 1, 'hello');

SELECT * FROM chats;
SELECT * FROM chats WHERE sender_id=1 AND receiver_id=1 AND sender_id != receiver_id;

DELETE FROM chats WHERE sender_id=receiver_id;

DROP TABLE chats;