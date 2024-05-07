INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

insert into user_tourist_app (id, username, password, email, firstname, lastname, role_id) values (12345, 'seli', '$2a$10$lAddMsBZ1QCXohuzuya0tOrElBmbGT2sAzkVJIHv7FTusHIIok7SC', 'seli@mail.com', 'seli', 'seli', 1);
insert into user_tourist_app (id, username, password, email, firstname, lastname, role_id) values (123456, 'admin', '$2a$10$6ZhsT7mosLU02Bw2cBr9dOS1pQEa7XzBZzP0XN/pYI7Ja10XPpnnS', 'admin@mail.com', 'admin', 'admin', 2);

INSERT INTO arrangement (average_rating, id, popular, price, state, date_added, description, grade, image, name, type) VALUES (4.5, 11, false, 100, false, '2024-05-05', 'This is a great arrangement','GOOD', 'https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg', 'Serbia tour', 'FAMILY');
INSERT INTO arrangement (average_rating, id, popular, price, state, date_added, description, grade, image, name, type) VALUES (3.2, 22, false, 200, false, '2023-03-05', 'This is a good arrangement','NEUTRAL', 'https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg', 'Serbia tour2', 'FAMILY');
INSERT INTO arrangement (average_rating, id, popular, price, state, date_added, description, grade, image, name, type) VALUES (4.5, 33, false, 100, false, '2023-05-05', 'This is a great arrangement','GOOD', 'https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg', 'Serbia tour', 'FAMILY');

INSERT INTO tour (arrangement_id, id_tour, participants_count, price, total_price, category, tour_description, tour_name) VALUES (11, 1123, 10, 100, 1000, 'HISTORICAL', 'This is a great tour', 'Serbia tour');
INSERT INTO tour (arrangement_id, id_tour, participants_count, price, total_price, category, tour_description, tour_name) VALUES (22, 2123, 20, 200, 4000, 'HISTORICAL', 'This is a great tour', 'Serbia tour2');

INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (11, 11, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (21, 11, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (311, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (41, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (51, 11, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (61, 11, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (71, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (81, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (91, 11, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (101, 11, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (111, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (121, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (131, 22, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (141, 22, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (151, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (161, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (171, 22, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (181, 22, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (191, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (201, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (211, 22, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (221, 22, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (231, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (241, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (251, 22, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (261, 22, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (271, 22, 12345, '2020-01-01', 3, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (281, 22, 12345, '2020-01-01', 2, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (291, 22, 12345, '2020-01-01', 5, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (301, 22, 12345, '2020-01-01', 4, 'Great tour!');
INSERT INTO rating (id,arrangement_id, user_id, rating_date, rating_value, comment) VALUES (3121, 22, 12345, '2020-01-01', 3, 'Great tour!');

