package com.tingeso.monolithicpep.services;


import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.entities.PlanillaEntity;
import com.tingeso.monolithicpep.repositories.PlanillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class PlanillaService {
    @Autowired

    PlanillaRepository planillaRepository;


    public ArrayList<PlanillaEntity> obtenerEmpleados(){
        return (ArrayList<PlanillaEntity>) planillaRepository.findAll();
    }

    @Transactional
    public void dropTable(){
        planillaRepository.dropTable();
    }

    public PlanillaEntity guardarPlanilla(PlanillaEntity planilla){
        return planillaRepository.save(planilla);
    }
}
