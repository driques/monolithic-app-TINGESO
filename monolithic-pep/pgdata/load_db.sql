--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-09-29 22:11:43 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 36573)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id_categoria character varying(100) NOT NULL,
    sueldo integer NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 36578)
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleado (
    rut integer NOT NULL,
    apellidos character varying(100) NOT NULL,
    nombres character varying(100) NOT NULL,
    fecha_nacimiento date NOT NULL,
    id_categoria character varying(100) NOT NULL,
    ingreso_empresa date NOT NULL
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 36618)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 36583)
-- Name: horas_extra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.horas_extra (
    id integer NOT NULL,
    fecha date,
    rut integer NOT NULL
);


ALTER TABLE public.horas_extra OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 36588)
-- Name: ingresos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingresos (
    rut integer NOT NULL,
    hora time without time zone NOT NULL,
    fecha date NOT NULL,
    id_ingresos integer NOT NULL
);


ALTER TABLE public.ingresos OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 36593)
-- Name: justificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.justificacion (
    id integer NOT NULL,
    rut integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.justificacion OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 36656)
-- Name: planilla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.planilla (
    id integer NOT NULL,
    anios_servicio integer NOT NULL,
    bonificacion integer NOT NULL,
    bruto integer NOT NULL,
    cotizacion_previsional integer NOT NULL,
    cotizacion_salud integer NOT NULL,
    horas_extra_monto integer NOT NULL,
    monto_descuento integer NOT NULL,
    nombre_empleado character varying(255),
    rut integer NOT NULL,
    sueldo_fijo integer NOT NULL,
    sueldo_final integer NOT NULL
);


ALTER TABLE public.planilla OWNER TO postgres;

--
-- TOC entry 3605 (class 0 OID 36573)
-- Dependencies: 209
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id_categoria, sueldo) FROM stdin;
a	1700000
b	1200000
c	800000
\.


--
-- TOC entry 3606 (class 0 OID 36578)
-- Dependencies: 210
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleado (rut, apellidos, nombres, fecha_nacimiento, id_categoria, ingreso_empresa) FROM stdin;
175869833	perez	juan	1997-08-24	a	2010-12-24
205953973	martinez	pedro	1990-08-01	b	2012-12-01
148299383	salgado	juana	1980-03-01	c	2009-12-01
204576719	paker	peter	1990-01-02	a	2015-10-02
277529824	jane	maryr	1980-05-06	b	2012-10-02
\.


--
-- TOC entry 3607 (class 0 OID 36583)
-- Dependencies: 211
-- Data for Name: horas_extra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.horas_extra (id, fecha, rut) FROM stdin;
2	2022-09-04	175869833
3	2022-09-04	175869833
4	2022-06-01	277529824
5	2022-06-02	277529824
6	2022-06-03	277529824
7	2022-09-05	205953973
145	2022-09-10	148299383
\.


--
-- TOC entry 3608 (class 0 OID 36588)
-- Dependencies: 212
-- Data for Name: ingresos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingresos (rut, hora, fecha, id_ingresos) FROM stdin;
175869833	08:00:00	2022-09-12	1
175869833	18:10:00	2022-09-12	2
175869833	08:10:00	2022-09-09	3
175869833	17:58:00	2022-09-09	4
175869833	07:58:00	2022-09-08	5
175869833	17:55:00	2022-09-08	6
205953973	08:02:00	2022-09-12	7
205953973	18:01:00	2022-09-12	8
205953973	08:18:00	2022-09-09	9
205953973	17:55:00	2022-09-09	10
205953973	08:05:00	2022-09-08	11
205953973	17:51:00	2022-09-08	12
148299383	07:58:00	2022-09-12	13
148299383	17:59:00	2022-09-12	14
148299383	08:01:00	2022-09-09	15
148299383	18:58:00	2022-09-09	16
148299383	08:05:00	2022-09-08	17
148299383	17:59:00	2022-09-08	18
\.


--
-- TOC entry 3609 (class 0 OID 36593)
-- Dependencies: 213
-- Data for Name: justificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.justificacion (id, rut, fecha) FROM stdin;
\.


--
-- TOC entry 3611 (class 0 OID 36656)
-- Dependencies: 215
-- Data for Name: planilla; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.planilla (id, anios_servicio, bonificacion, bruto, cotizacion_previsional, cotizacion_salud, horas_extra_monto, monto_descuento, nombre_empleado, rut, sueldo_fijo, sueldo_final) FROM stdin;
161	11	85000	1785000	178500	142800	0	0	juan perez	175869833	1700000	1463700
162	9	60000	1260000	126000	100800	0	0	pedro martinez	205953973	1200000	1033200
163	12	40000	840000	84000	67200	0	0	juana salgado	148299383	800000	688800
164	6	85000	1374450	137445	109956	0	410550	peter paker	204576719	1700000	1127049
165	9	60000	1247400	124740	99792	0	12600	maryr jane	277529824	1200000	1022868
\.


--
-- TOC entry 3617 (class 0 OID 0)
-- Dependencies: 214
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 165, true);


--
-- TOC entry 3451 (class 2606 OID 36577)
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);


--
-- TOC entry 3453 (class 2606 OID 36582)
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (rut);


--
-- TOC entry 3455 (class 2606 OID 36620)
-- Name: horas_extra horas_extra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horas_extra
    ADD CONSTRAINT horas_extra_pkey PRIMARY KEY (id);


--
-- TOC entry 3457 (class 2606 OID 36592)
-- Name: ingresos ingresos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingresos
    ADD CONSTRAINT ingresos_pkey PRIMARY KEY (id_ingresos);


--
-- TOC entry 3459 (class 2606 OID 36597)
-- Name: justificacion justificacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.justificacion
    ADD CONSTRAINT justificacion_pkey PRIMARY KEY (id);


--
-- TOC entry 3461 (class 2606 OID 36660)
-- Name: planilla planilla_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planilla
    ADD CONSTRAINT planilla_pkey PRIMARY KEY (id);


--
-- TOC entry 3462 (class 2606 OID 36598)
-- Name: empleado empleado_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria) NOT VALID;


--
-- TOC entry 3464 (class 2606 OID 36608)
-- Name: ingresos rut; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingresos
    ADD CONSTRAINT rut FOREIGN KEY (rut) REFERENCES public.empleado(rut) NOT VALID;


--
-- TOC entry 3465 (class 2606 OID 36613)
-- Name: justificacion rut; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.justificacion
    ADD CONSTRAINT rut FOREIGN KEY (rut) REFERENCES public.empleado(rut) NOT VALID;


--
-- TOC entry 3463 (class 2606 OID 36621)
-- Name: horas_extra rut; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horas_extra
    ADD CONSTRAINT rut FOREIGN KEY (rut) REFERENCES public.empleado(rut) NOT VALID;


-- Completed on 2022-09-29 22:11:44 -03

--
-- PostgreSQL database dump complete
--

