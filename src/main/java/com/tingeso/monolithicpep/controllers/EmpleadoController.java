package com.tingeso.monolithicpep.controllers;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<EmpleadoEntity> empleados=empleadoService.obtenerEmpleados();
        model.addAttribute("empleados",empleados);
        return "index_listar";
    }



}