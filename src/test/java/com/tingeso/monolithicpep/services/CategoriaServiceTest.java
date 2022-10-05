package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.repositories.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoriaServiceTest {
    @Mock
    CategoriaRepository categoriaRepository;
    @InjectMocks
    CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getSueldoById() {
        when(categoriaRepository.getSueldoById("1")).thenReturn(100000);
        assertNotNull(categoriaService.getSueldoById("1"));
    }
}