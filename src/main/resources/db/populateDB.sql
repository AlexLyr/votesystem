DELETE FROM USERS;
DELETE FROM user_roles;
DELETE FROM USER_VOTES;
DELETE FROM MEALS;
DELETE FROM MENU;
DELETE FROM RESTAURANTS;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100;


INSERT INTO USERS (EMAIL, NAME, PASSWORD) VALUES
  ('user@yandex.ru', 'User', 'user'),
  ('admin@gmail.com', 'Admin', 'admin');

INSERT INTO USER_ROLES (ROLE, USER_ID) VALUES ('ROLE_USER', 100), ('ROLE_ADMIN', 101);

INSERT INTO RESTAURANTS (NAME) VALUES ('KFC'), ('Баклажан'), ('Столовая');


INSERT INTO MENU (DATE, restaurant_id) VALUES
  (TODAY(), 102), ('2017-10-22', 102),
  (TODAY(), 103), ('2017-10-22', 103),
  (TODAY(), 104), ('2017-10-22', 104);

INSERT INTO MEALS (NAME, PRICE, MENU_ID) VALUES
  ('Стрипсы', 100.1, 105), ('Фри', 74.5, 105),
  ('Старые стрипсы', 90, 106), ('Несвежая картошка', 50, 106),
  ('Хачапури', 450, 107), ('Борщ', 90.6, 107),
  ('Старое Хачапури', 300, 108), ('Несвежий суп', 60, 108),
  ('Гречка', 20.2, 109), ('Курица', 80.3, 109),
  ('Вчерашняя гречка', 20, 110), ('Несвежая курица', 50, 110);