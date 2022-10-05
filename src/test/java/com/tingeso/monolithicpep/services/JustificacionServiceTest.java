package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.JustificacionEntity;
import com.tingeso.monolithicpep.repositories.JustificacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class JustificacionServiceTest {
    @Mock
    JustificacionRepository justificacionRepository;

    @InjectMocks
    JustificacionService justificacionService;

    JustificacionEntity justificacionEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        justificacionEntity = new JustificacionEntity();
        LocalDate fecha = LocalDate.of(1999, 12, 12);
        justificacionEntity.setId(1);
        justificacionEntity.setRut(1);
        justificacionEntity.setFecha(fecha);

    }

    @Test
    void obtenerJustificaciones() {
        when(justificacionRepository.findAll()).thenReturn(Arrays.asList(justificacionEntity));
        assertNotNull(justificacionService.obtenerJustificaciones());
    }

    @Test
    void guardarJustificacion() {
        when(justificacionRepository.save(justificacionEntity)).thenReturn(justificacionEntity);
        assertNotNull(justificacionService.guardarJustificacion(justificacionEntity));
    }

    @Test
    void findMaxId() {
        when(justificacionRepository.findMaxId()).thenReturn(1);
        assertNotNull(justificacionService.findMaxId());
    }

    @Test
    void obtenerPorId() {
        when(justificacionRepository.findById(1)).thenReturn(java.util.Optional.of(justificacionEntity));
        assertNotNull(justificacionService.obtenerPorId(1));
    }

    @Test
    void getDatesByRut() {
        when(justificacionRepository.getDateByRut(1)).thenReturn(new String[]{"1999-12-12"});
        assertNotNull(justificacionService.getDatesByRut(1));
    }

    @Test
    void eliminarJustificacion() {
        doNothing().when(justificacionRepository).deleteById(1);
        assertTrue(justificacionService.eliminarJustificacion(1));
    }
}