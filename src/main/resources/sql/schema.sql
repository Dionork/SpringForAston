DROP TABLE IF EXISTS heroes CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS fractions CASCADE;
DROP TABLE IF EXISTS hero_fractions CASCADE;
DROP TABLE IF EXISTS heroes_maxhp CASCADE;

CREATE TABLE IF NOT EXISTS roles
(role_name_id  bigserial PRIMARY KEY,
role_name VARCHAR(255) NOT NULL UNIQUE);

INSERT INTO roles (role_name)
VALUES  ('Воин'), --1
        ('Маг'), --2
        ('Лучник'); --3

CREATE TABLE IF NOT EXISTS heroes
( hero_id bigserial PRIMARY KEY,
hero_name VARCHAR(255) NOT NULL UNIQUE,
hero_lastname VARCHAR(255) NOT NULL UNIQUE,
role_name_id BIGINT REFERENCES roles(role_name_id));


CREATE TABLE IF NOT EXISTS fractions
(fraction_id bigserial PRIMARY KEY,
fraction_name VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS heroes_fractions
( hero_id BIGINT REFERENCES heroes(hero_id),
fraction_id BIGINT REFERENCES fractions(fraction_id));

INSERT INTO heroes (hero_name,hero_lastname, role_name_id)
VALUES  ('Тралл', 'Огриммаров',  1), --1
        ('Сильвана', 'Ветрокрылова',  3), --2
        ('Иллидан', 'Яростьбурьев',  1), --3
        ('Артас', 'Менетилов',  1), --4
        ('Гарош', 'Адскокриков',  1), --5
        ('Джайна', 'Праудмур',  2), --6
        ('Кадгар', 'Верхомагов', 2); --7
INSERT INTO fractions (fraction_name)
VALUES  ('Альянс'), --1
        ('Орда'); --2

INSERT INTO heroes_fractions (hero_id,fraction_id)
VALUES  (1,2), --1
        (2,1), --2
        (3,1), --3
        (4,1), --4
        (5,2), --5
        (6,1), --6
        (7,1); --7
