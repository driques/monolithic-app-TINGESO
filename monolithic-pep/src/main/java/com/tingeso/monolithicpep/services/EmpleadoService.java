package com.tingeso.monolithicpep.services;


import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<EmpleadoEntity> obtenerPorId(int rut){
        return empleadoRepository.findById(rut);
    }

/*
    public EmpleadoEntity obtenerPorRut(int rut){
        return EmpleadoRepository.findByRut(rut);
    }*/

    public boolean eliminarEmpleado(int rut) {
        try{
            empleadoRepository.deleteById(rut);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}