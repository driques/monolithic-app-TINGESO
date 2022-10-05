package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.entities.JustificacionEntity;
import com.tingeso.monolithicpep.repositories.OfficinaRRHHRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OficinaRRHHServiceTest {
    @Autowired
    private OfficinaRRHHRepository repository;

    EmpleadoService empleadoService = new EmpleadoService();
    EmpleadoEntity empleadoEntity = new EmpleadoEntity();
    HorasExtraService horasExtraService = new HorasExtraService();
    JustificacionService justificacionService = new JustificacionService();
    OficinaRRHHService oficinaRRHHService = new OficinaRRHHService();
    PlanillaService planillaService = new PlanillaService();
    String[] myArray ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String myTest = "1";

    int sueldoBruto = 100000;
    int montoDescuento = 10000;

    char categoriaTest = 'a';
    int horasTest = 1;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void myContains() {
        assertTrue(oficinaRRHHService.myContains(myArray,myTest));

    }


    @Test
    public void montoHoraExtra() {
        assertTrue(oficinaRRHHService.montoHoraExtra(categoriaTest,horasTest) == 25000);
    }

    @Test
    public void sueldoFijo() {
        assertTrue(oficinaRRHHService.sueldoFijo(categoriaTest) == 25000);
    }


    @Test
    public void brutoSinCotizacion() {
        assertTrue(oficinaRRHHService.brutoSinCotizacion(sueldoBruto,montoDescuento) == 90000);
    }

    @Test
    public void getCotizacionPrevisional() {
        assertTrue(oficinaRRHHService.getCotizacionPrevisional(sueldoBruto) == 10000);
    }

    @Test
    public void getCotizacionSalud() {
        assertTrue(oficinaRRHHService.getCotizacionSalud(sueldoBruto) == 8000);
    }
}