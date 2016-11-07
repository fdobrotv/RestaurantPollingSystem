INSERT INTO users (id, email, login, fio, password) VALUES
(0, 'petkya@yandex.ru', 'petkya', 'Петька Как Его-там', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
(1, 'katya@gmail.com', 'katya', 'Екатерина Африкантова Зубкевич', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
(2, 'noc@fdobrotv.com', 'admin', 'Василий Иваночич Чапаев', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 0), ('ROLE_USER', 1), ('ROLE_ADMIN', 2);

INSERT INTO restaurant (id, name) VALUES (0,'McDonalds'), (1,'KFC'), (2,'Burger King'), (3,'Italiano'), (4,'Хмельная №1');

INSERT INTO menu (ID, MENU_DATE, RESTAURANT_ID) VALUES
(0, TODAY(), 0)
(1, '2016-10-28', 0),
(2, TODAY(), 1),
(3, '2016-10-28', 1),
(4, TODAY(), 2),
(5, '2016-10-28', 2);

INSERT INTO lunch (NAME, PRICE, MENU_ID) VALUES
('Гамбургер', 350, 0), ('Фри', 95, 0),
('Вчерашний Гамбургер', 340, 1), ('Вчерашнее Фри', 90, 1),
('Суп', 650, 2), ('Второе', 750, 2),
('Вчерашний Суп', 660, 3), ('Вчерашнее Второе', 705, 3),
('Суши', 450, 4), ('Лосось', 560, 4),
('Вчерашний Суши', 455, 5), ('Вчерашний Лосось', 520, 5);