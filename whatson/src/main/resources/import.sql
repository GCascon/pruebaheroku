/* Populate tables */
INSERT INTO lugares(nombre) VALUES ('Madrid');
INSERT INTO lugares(nombre) VALUES ('Salamanca');
INSERT INTO lugares(nombre) VALUES ('Santiago');

INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo) VALUES('Mercado de San Ildefonso', 'Desc. Mercado', 'Mercado de San Ildefonso, Madrid','http://www.google.es',1,'Tapeo');
INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo) VALUES('Mercado de San Ant�n', 'Desc. Mercado', 'Mercado de Ant�n, Madrid','http://www.google.es',1,'Tapeo');
INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo) VALUES('Mercado de Ant�n Mart�n', 'Desc. Mercado', 'Mercado de Ant�n Mart�n, Madrid','http://www.google.es',1,'Tapeo');

INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$ocQSHo5JtkJkEQn0NssOlOE8MJfh0LwXGJa6U5vdj7MAdUXqTOaRC',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_ADMIN');
