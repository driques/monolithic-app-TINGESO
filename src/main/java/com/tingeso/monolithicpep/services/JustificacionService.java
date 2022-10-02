package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.JustificacionEntity;
import com.tingeso.monolithicpep.repositories.JustificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JustificacionService {
    @Autowired
    JustificacionRepository justificacionRepository;

    public ArrayList<JustificacionEntity> obtenerJustificaciones(){
        return (ArrayList<JustificacionEntity>) justificacionRepository.findAll();
    }

    public JustificacionEntity guardarJustificacion(JustificacionEntity justificacion){
        return justificacionRepository.save(justificacion);
    }

    public int findMaxId(){
        try{
            int maxId = justificacionRepository.findMaxId();
            return maxId + 1;

        }
        catch (Exception e){
            return 1;
        }

    }

    public Optional<JustificacionEntity> obtenerPorId(int id){
        return justificacionRepository.findById(id);
    }

/*
    public EmpleadoEntity obtenerPorRut(int rut){
        return EmpleadoRepository.findByRut(rut);
    }*/
    public String[] getDatesByRut(int rut){
    return justificacionRepository.getDateByRut(rut);
}
    public boolean eliminarJustificacion(int id) {
        try{
            justificacionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}