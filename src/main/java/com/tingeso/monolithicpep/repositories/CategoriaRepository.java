package com.tingeso.monolithicpep.repositories;

import com.tingeso.monolithicpep.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity,String> {
    @Query(value = "select sueldo from categoria where id_categoria= :rut", nativeQuery = true)
    int getSueldoById(@Param("rut") String rut);
}
