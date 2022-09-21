package com.tingeso.monolithicpep.repositories;

import com.tingeso.monolithicpep.entities.HorasExtraEntity;
import com.tingeso.monolithicpep.entities.JustificacionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HorasExtraRepository extends CrudRepository<HorasExtraEntity, Integer> {

    @Query(value = "select max(id) from horas_extra",nativeQuery = true)
    int findMaxId();

    @Query(value = "select fecha from horas_extra as e where e.rut = :rut",
            nativeQuery = true)
    String[] getDateByRut(@Param("rut") int rut);

    /*
    @Query(value = "select * from justificacion as e where e.rut = :rut",
            nativeQuery = true)
    JustificacionEntity findByNameNativeQuery(@Param("rut") int rut);*/

}