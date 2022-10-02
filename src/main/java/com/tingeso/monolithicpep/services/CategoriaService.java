package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public int getSueldoById(String id){
        return categoriaRepository.getSueldoById(id);
    }

}
