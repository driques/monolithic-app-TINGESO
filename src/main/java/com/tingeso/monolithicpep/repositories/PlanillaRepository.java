package com.tingeso.monolithicpep.repositories;

import com.tingeso.monolithicpep.entities.PlanillaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaRepository extends CrudRepository<PlanillaEntity,Integer> {
    @Modifying
    @Query(value = "TRUNCATE TABLE planilla;",nativeQuery = true)
    boolean dropTable();
}
