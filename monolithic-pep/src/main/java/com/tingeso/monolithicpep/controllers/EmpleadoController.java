package com.tingeso.monolithicpep.controllers;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.repositories.EmpleadoRepository;
import com.tingeso.monolithicpep.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listar(Model model) {
        ArrayList<EmpleadoEntity> empleados=empleadoService.obtenerEmpleados();
        model.addAttribute("empleados",empleados);
        return "index";
    }
    @GetMapping(value = "/justificar/{rut}")
    public String formsJustificar(@PathVariable int rut, Model model){
        System.out.println(empleadoService.obtenerPorId(rut));
        empleadoService.obtenerPorId(rut).ifPresent(empleado-> model.addAttribute("empleadoJustificar",empleado));
        return "justificar-empleado";
    }


}