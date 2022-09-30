package com.tingeso.monolithicpep.controllers;


import com.tingeso.monolithicpep.entities.JustificacionEntity;
import com.tingeso.monolithicpep.services.JustificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JustificativoController {

    @Autowired
    JustificacionService justificacionService;
    @PostMapping("/justificar/{id}")
    public String crearJustificacion(@ModelAttribute JustificacionEntity justificacion){
        int myNewId = justificacionService.findMaxId();
        justificacion.setNewId(myNewId);
        System.out.println("testPost..."+justificacion);

        justificacionService.guardarJustificacion(justificacion);

        System.out.println("testPost..."+justificacion);
        System.out.println("justificacion guardada...");
        return "index";


    }
    @GetMapping(value = "/justificar/{rut}")
    public String formsJustificar(@PathVariable int rut, Model model){
        JustificacionEntity crearJustificacion = new JustificacionEntity();
        crearJustificacion.setRut(rut);
        model.addAttribute("empleadoJustificar",crearJustificacion );
        return "justificar-empleado";
    }

}
