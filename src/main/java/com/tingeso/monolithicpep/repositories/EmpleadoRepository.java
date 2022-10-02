package com.tingeso.monolithicpep.repositories;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Integer> {
    //public EmpleadoEntity findByRut(int rut);

    @Query("select e from EmpleadoEntity e where e.rut = :rut")
    EmpleadoEntity findByRut(@Param("rut") int rut);

    @Query(value = "select * from empleados as e where e.nombres = :nombres",
            nativeQuery = true)
    EmpleadoEntity findByNameNativeQuery(@Param("nombres") String nombres);

    @Query(value = "select sueldo, rut from categoria, empleado where empleado.rut = :rut and categoria.id_categoria = empleado.id_categoria ", nativeQuery = true)
    int getSueldoByRut(@Param("rut") int rut);

    @Query(value = "select ingreso_empresa from empleado where empleado.rut = :rut", nativeQuery = true)
    LocalDate getAnioIngreso(@Param("rut") int rut);

}