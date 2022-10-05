package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.HorasExtraEntity;
import com.tingeso.monolithicpep.repositories.HorasExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorasExtraService {
    @Autowired
    HorasExtraRepository horasExtraRepository;
    public List<HorasExtraEntity> obtenerHorasExtra() {
        return (List<HorasExtraEntity>) horasExtraRepository.findAll();
    }

    public HorasExtraEntity guardarHoraExtra(HorasExtraEntity horasExtra) {
        return horasExtraRepository.save(horasExtra);
    }

    public int findMaxId() {
        try {
            int maxId = horasExtraRepository.findMaxId();
            return maxId + 1;

        } catch (Exception e) {
            return 1;
        }

    }
    public String[] getDatesByRut(int rut){
        return horasExtraRepository.getDateByRut(rut);
    }

    public Optional<HorasExtraEntity> obtenerPorId(int id) {
        return horasExtraRepository.findById(id);
    }


}