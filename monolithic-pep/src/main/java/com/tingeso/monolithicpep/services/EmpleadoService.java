package com.tingeso.monolithicpep.services;


import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoEntity> obtenerEmpleados(){
        return (ArrayList<EmpleadoEntity>) empleadoRepository.findAll();
    }

    public EmpleadoEntity guardarEmpleado(EmpleadoEntity empleado){
        return empleadoRepository.save(empleado);
    }

    public EmpleadoEntity obtenerPorRut(int rut){
        return empleadoRepository.findByRut(rut);
    }

    public int getSueldos(int rut){
        return empleadoRepository.getSueldoByRut(rut);
    }
    public LocalDate getAnioIngreso(int rut){
        return empleadoRepository.getAnioIngreso(rut);
    }

    public boolean eliminarEmpleado(int rut) {
        try{
            empleadoRepository.deleteById(rut);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}