package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.HorasExtraEntity;
import com.tingeso.monolithicpep.repositories.HorasExtraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HorasExtraServiceTest {
    @Mock
    HorasExtraRepository horasExtraRepository;
    @InjectMocks
    HorasExtraService horasExtraService;
    HorasExtraEntity horasExtraEntity;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        LocalDate fecha = LocalDate.of(1999, 12, 12);
        horasExtraEntity = new HorasExtraEntity();
        horasExtraEntity.setId(1);
        horasExtraEntity.setRut(1);
        horasExtraEntity.setFecha(fecha);
    }

    @Test
    void obtenerHorasExtra() {
        when(horasExtraRepository.findAll()).thenReturn(Arrays.asList(horasExtraEntity));
        assertNotNull(horasExtraService.obtenerHorasExtra());


    }

    @Test
    void guardarHoraExtra() {
        when(horasExtraRepository.save(horasExtraEntity)).thenReturn(horasExtraEntity);
        assertNotNull(horasExtraService.guardarHoraExtra(horasExtraEntity));
    }

    @Test
    void findMaxId() {
        when(horasExtraRepository.findMaxId()).thenReturn(1);
        assertNotNull(horasExtraService.findMaxId());
    }

    @Test
    void getDatesByRut() {
        when(horasExtraRepository.getDateByRut(1)).thenReturn(new String[]{"1999-12-12"});
        assertNotNull(horasExtraService.getDatesByRut(1));
    }

    @Test
    void obtenerPorId() {
        when(horasExtraRepository.findById(1)).thenReturn(java.util.Optional.of(horasExtraEntity));
        assertNotNull(horasExtraService.obtenerPorId(1));
    }
}