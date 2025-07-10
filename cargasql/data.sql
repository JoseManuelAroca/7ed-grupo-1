--users password admin 12345
INSERT INTO public.users (active, id, profile_settings, verifier, user_points,
                          country, name, nick, surname, password, email, biography, image)
VALUES (true, 1, false, false, 0, null, 'José Manuel',
        'pepe', 'Aroca', '$2a$10$Hyxi8/ry4qBcUjfzmV0BceF4xhZANhn9tN12KwCmI8T9D/hfJjaD6',
        'jose.manuel.aroca@hotmail.com', null, null);
INSERT INTO public.users (active, id, profile_settings, verifier, user_points,
                          country, name, nick, surname, password, email, biography, image)
VALUES (true, 2, false, false, 0, null, 'Admin',
        'Admin1', 'Admin2', '$2a$10$Hyxi8/ry4qBcUjfzmV0BceF4xhZANhn9tN12KwCmI8T9D/hfJjaD6',
        'admin@hotmail.com', null, null);
--roles

insert into rol (id,name) values(1,'ROLE_USER');
insert into rol (id,name) values(2,'ROLE_ADMIN');
-- Consolas
INSERT INTO consoles (id, name)
SELECT 1, 'PS5'
    WHERE NOT EXISTS (SELECT 1 FROM consoles WHERE id = 1);

INSERT INTO consoles (id, name)
SELECT 2, 'Xbox'
    WHERE NOT EXISTS (SELECT 1 FROM consoles WHERE id = 2);

INSERT INTO consoles (id, name)
SELECT 3, 'Nintendo Switch'
    WHERE NOT EXISTS (SELECT 1 FROM consoles WHERE id = 3);

INSERT INTO consoles (id, name)
SELECT 4, 'PC'
    WHERE NOT EXISTS (SELECT 1 FROM consoles WHERE id = 4);

-- Juegos
INSERT INTO games (id, name)
SELECT 1, 'FIFA 25'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 1);

INSERT INTO games (id, name)
SELECT 2, 'Mortal Kombat'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 2);

INSERT INTO games (id, name)
SELECT 3, 'Tekken 8'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 3);

INSERT INTO games (id, name)
SELECT 4, 'Street Fighter'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 4);

INSERT INTO games (id, name)
SELECT 5, 'Smash Bros ultimate'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 5);

INSERT INTO games (id, name)
SELECT 6, 'Pokemon VGC'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 6);

INSERT INTO games (id, name)
SELECT 7, 'Rocket League'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 7);

INSERT INTO games (id, name)
SELECT 8, 'Splatoon 3'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 8);

INSERT INTO games (id, name)
SELECT 9, 'Valorant'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 9);

INSERT INTO games (id, name)
SELECT 10, 'Call of Duty'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 10);

INSERT INTO games (id, name)
SELECT 11, 'Overwatch'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 11);

INSERT INTO games (id, name)
SELECT 12, 'League of Legends'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 12);

INSERT INTO games (id, name)
SELECT 13, 'Counter Strike'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 13);

INSERT INTO games (id, name)
SELECT 14, 'Mario Kart'
    WHERE NOT EXISTS (SELECT 1 FROM games WHERE id = 14);

-- Relación Consolas - Juegos (tabla intermedia consoles_games)

-- Juegos de la PS5
INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 1
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 1);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 9
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 9);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 2
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 2);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 3
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 3);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 10
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 10);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 1, 4
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 1 AND games_id = 4);

-- Juegos de la Xbox
INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 1
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 1);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 10
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 10);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 4
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 4);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 2
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 2);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 3
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 3);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 2, 9
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 2 AND games_id = 9);

-- Juegos de la Nintendo Switch
INSERT INTO consoles_games (consoles_id, games_id)
SELECT 3, 14
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 3 AND games_id = 14);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 3, 5
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 3 AND games_id = 5);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 3, 6
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 3 AND games_id = 6);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 3, 8
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 3 AND games_id = 8);

-- Juegos de la PC
INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 1
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 1);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 9
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 9);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 11
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 11);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 12
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 12);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 10
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 10);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 7
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 7);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 13
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 13);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 3
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 3);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 2
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 2);

INSERT INTO consoles_games (consoles_id, games_id)
SELECT 4, 4
    WHERE NOT EXISTS (SELECT 1 FROM consoles_games WHERE consoles_id = 4 AND games_id = 4);