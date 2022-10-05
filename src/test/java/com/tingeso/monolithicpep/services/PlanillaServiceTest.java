package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.PlanillaEntity;
import com.tingeso.monolithicpep.repositories.EmpleadoRepository;
import com.tingeso.monolithicpep.repositories.PlanillaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class PlanillaServiceTest {
    @Mock
    PlanillaRepository planillaRepository;
    @InjectMocks
    PlanillaService planillaService;

    PlanillaEntity planillaEntity = new PlanillaEntity();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        planillaEntity.setId(1);
        planillaEntity.setRut(205953973);
        planillaEntity.setNombre_empleado("Juan Perez");
        planillaEntity.setAnios_servicio(2);
        planillaEntity.setSueldo_fijo(100000);
        planillaEntity.setBonificacion(20000);
        planillaEntity.setHoras_extra_monto(10000);
        planillaEntity.setMonto_descuento(10);
        planillaEntity.setBruto(130000);
        planillaEntity.setCotizacion_salud(13000);
        planillaEntity.setCotizacion_previsional(13000);
        planillaEntity.setSueldo_final(104000);

    }

    @Test
    public void obtenerEmpleados() {
        when(planillaRepository.findAll()).thenReturn(Arrays.asList(planillaEntity));
    }

    @Test
    public void dropTable(){
        doNothing().when(planillaRepository).deleteAll();
        planillaService.dropTable();
    }

    @Test
    public void guardarPlanilla() {
        when(planillaRepository.save(planillaEntity)).thenReturn(planillaEntity);
        assertNotNull(planillaService.guardarPlanilla(planillaEntity));
    }
}