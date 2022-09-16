
INSERT INTO categoria(id_categoria,sueldo)
VALUES ('a',1700000);
INSERT INTO categoria(id_categoria,sueldo)
VALUES ('b',1200000);
INSERT INTO categoria(id_categoria,sueldo)
VALUES ('c',800000);

INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (1,'perez','juan','1997-08-24','a','2010-12-24');

INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (2,'martinez','pedro','1990-08-01','b','2012-12-01');

INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (3,'salgado','juana','1980-03-01','c','2009-12-01');

INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (1,1,'08:00:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (2,1,'18:10:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (3,1,'08:10:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (4,1,'17:58:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (5,1,'07:58:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (6,1,'17:55:00','2022-09-08');


INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (7,2,'08:02:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (8,2,'18:01:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (9,2,'08:18:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (10,2,'17:55:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (11,2,'08:05:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (12,2,'17:51:00','2022-09-08');

INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (13,3,'07:58:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (14,3,'17:59:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (15,3,'08:01:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (16,3,'18:58:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (17,3,'08:05:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (18,3,'17:59:00','2022-09-08');


INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (1,'a',25000);

INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (2,'b',20000);

INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (3,'c',10000);
