package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.controllers.EmpleadoController;
import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.repositories.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class EmpleadoServiceTest {
    @Mock
    EmpleadoRepository empleadoRepository;
    @InjectMocks
    EmpleadoService empleadoService;

    EmpleadoEntity empleadoEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        empleadoEntity = new EmpleadoEntity();
        LocalDate fecha = LocalDate.of(1999, 12, 12);
        empleadoEntity.setRut(1);
        empleadoEntity.setNombres("Juan");
        empleadoEntity.setApellidos("Perez");
        empleadoEntity.setId_categoria("a");
        empleadoEntity.setFecha_nacimiento("1990-01-01");
        empleadoEntity.setIngreso_empresa(fecha);
    }

    @Test
    void obtenerEmpleados() {
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleadoEntity));
        assertNotNull(empleadoService.obtenerEmpleados());
    }

    @Test
    void guardarEmpleado() {
        when(empleadoRepository.save(empleadoEntity)).thenReturn(empleadoEntity);
        assertNotNull(empleadoService.guardarEmpleado(empleadoEntity));
    }

    @Test
    void obtenerPorRut() {
        when(empleadoRepository.findByRut(1)).thenReturn(empleadoEntity);
        assertNotNull(empleadoService.obtenerPorRut(1));
    }

    @Test
    void getSueldos() {
        when(empleadoRepository.getSueldoByRut(1)).thenReturn(100000);
        assertNotNull(empleadoService.getSueldos(1));
    }

    @Test
    void getAnioIngreso() {
        when(empleadoRepository.getAnioIngreso(1)).thenReturn(LocalDate.of(1999, 12, 12));
        assertNotNull(empleadoService.getAnioIngreso(1));
    }

    @Test
    void eliminarEmpleado() {
        doNothing().when(empleadoRepository).deleteById(1);
        assertTrue(empleadoService.eliminarEmpleado(1));
    }
}