INSERT INTO categoria(id_categoria,sueldo)
VALUES ('a',1700000);
INSERT INTO categoria(id_categoria,sueldo)
VALUES ('b',1200000);
INSERT INTO categoria(id_categoria,sueldo)
VALUES ('c',800000);
 
INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (175869833,'perez','juan','1997-08-24','a','2010-12-24');
 
INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (205953973,'martinez','pedro','1990-08-01','b','2012-12-01');
 
INSERT INTO empleado(rut, apellidos,nombres,fecha_nacimiento,id_categoria,ingreso_empresa)
VALUES (148299383,'salgado','juana','1980-03-01','c','2009-12-01');
 
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (1,175869833,'08:00:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (2,175869833,'18:10:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (3,175869833,'08:10:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (4,175869833,'17:58:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (5,175869833,'07:58:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (6,175869833,'17:55:00','2022-09-08');
 
 
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (7,205953973,'08:02:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (8,205953973,'18:01:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (9,205953973,'08:18:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (10,205953973,'17:55:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (11,205953973,'08:05:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (12,205953973,'17:51:00','2022-09-08');
 
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (13,148299383,'07:58:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (14,148299383,'17:59:00','2022-09-12');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (15,148299383,'08:01:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (16,148299383,'18:58:00','2022-09-09');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (17,148299383,'08:05:00','2022-09-08');
INSERT INTO ingresos(id_ingresos,rut,hora,fecha)
VALUES (18,148299383,'17:59:00','2022-09-08');
 
 
INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (175869833,'a',25000);
 
INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (205953973,'b',20000);
 
INSERT INTO horas_extra(id_he,id_categoria,monto_hora)
VALUES (148299383,'c',10000);
