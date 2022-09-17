package com.tingeso.monolithicpep.repositories;

import com.tingeso.monolithicpep.entities.JustificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificacionRepository extends CrudRepository<JustificacionEntity, Integer>{
    //public JustificacionEntity findMaxId();

    @Query(value = "select max(id) from justificacion",nativeQuery = true)
     int findMaxId();

    @Query(value = "select * from justificacion as e where e.rut = :rut",
            nativeQuery = true)
    JustificacionEntity findByNameNativeQuery(@Param("rut") int rut);

}