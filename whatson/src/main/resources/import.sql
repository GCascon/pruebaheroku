/* Populate tables */
INSERT INTO lugares(nombre) VALUES ('Madrid');
INSERT INTO lugares(nombre) VALUES ('Salamanca');
INSERT INTO lugares(nombre) VALUES ('Santiago');
INSERT INTO lugares(id,nombre) VALUES (0,'Cerca de mi');

INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo, latitud, longitud) VALUES('Mercado de San Ildefonso', 'Desc. Mercado', 'Mercado de San Ildefonso, Madrid','http://www.google.es',1,'Tapeo','40.424234', '-3.700822');
INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo, latitud, longitud) VALUES('Mercado de San Anton', 'Desc. Mercado', 'Mercado de Ant�n, Madrid','http://www.google.es',1,'Tapeo', '40.422072', '-3.697689');
INSERT INTO favoritos (nombre, descripcion, direccion, url, lugar_id, tipo, latitud, longitud) VALUES('Mercado de Ant�n Mart�n', 'Desc. Mercado', 'Mercado de Ant�n Mart�n, Madrid','http://www.google.es',1,'Tapeo', '40.411604', '-3.698698');

INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$ocQSHo5JtkJkEQn0NssOlOE8MJfh0LwXGJa6U5vdj7MAdUXqTOaRC',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_ADMIN');

 

INSERT INTO favoritos (descripcion, direccion, nombre, tipo, url, lugar_id, latitud, longitud) VALUES('Plaza Mayor de Madrid', 'Plaza Mayor, Madrid', 'Plaza Mayor', 'Turismo','-', 1, '40.415509', '-3.707431');
INSERT INTO favoritos (descripcion, direccion, nombre, tipo, url, lugar_id, latitud, longitud) VALUES('Puerta del Sol ', 'Puerta del Sol, madrid', 'Puerta del Sol', 'Turismo','-', 1, '40.41692', '-3.703519');
INSERT INTO favoritos (descripcion, direccion, nombre, tipo, url, lugar_id, latitud, longitud) VALUES('Parque del Retiro', 'Parque del Retiro, Madrid', 'Parque del Retiro', 'Turismo','-', 1, '40.415122', '-3.683877');
INSERT INTO favoritos (descripcion, direccion, nombre, tipo, url, lugar_id, latitud, longitud) VALUES('Templo de Debod', 'Templo de Debod, Madrid', 'Templo de Debod', 'Turismo','-', 1, '40.424006', '-3.717797');
