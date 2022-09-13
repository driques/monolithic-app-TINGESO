BEGIN;


CREATE TABLE IF NOT EXISTS public.categoria
(
    id_categoria character varying(100) COLLATE pg_catalog."default" NOT NULL,
    sueldo integer NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria)
);

CREATE TABLE IF NOT EXISTS public.empleado
(
    rut integer NOT NULL,
    apellidos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nombres character varying(100) COLLATE pg_catalog."default" NOT NULL,
    fecha_nacimiento date NOT NULL,
    id_categoria character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ingreso_empresa date NOT NULL,
    CONSTRAINT empleado_pkey PRIMARY KEY (rut)
);

CREATE TABLE IF NOT EXISTS public.horas_extra
(
    id_he integer NOT NULL,
    monto_hora integer NOT NULL,
    id_categoria character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT horas_extra_pkey PRIMARY KEY (id_he)
);

CREATE TABLE IF NOT EXISTS public.ingresos
(
    rut integer NOT NULL,
    hora time without time zone NOT NULL,
    fecha date NOT NULL,
    id_ingresos integer NOT NULL,
    PRIMARY KEY (id_ingresos)
);

ALTER TABLE IF EXISTS public.empleado
    ADD CONSTRAINT empleado_fkey FOREIGN KEY (id_categoria)
    REFERENCES public.categoria (id_categoria) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.horas_extra
    ADD CONSTRAINT categoria FOREIGN KEY (id_categoria)
    REFERENCES public.categoria (id_categoria) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.ingresos
    ADD CONSTRAINT rut FOREIGN KEY (rut)
    REFERENCES public.empleado (rut) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;
