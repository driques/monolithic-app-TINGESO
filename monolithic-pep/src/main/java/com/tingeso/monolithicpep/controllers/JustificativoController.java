package com.tingeso.monolithicpep.controllers;


import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.entities.JustificacionEntity;
import com.tingeso.monolithicpep.services.EmpleadoService;
import com.tingeso.monolithicpep.services.JustificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class JustificativoController {

    @Autowired
    JustificacionService justificacionService;
    @PostMapping("/empleado/justificar/{id}")
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
        System.out.println(rut+"<- rut");
        JustificacionEntity crearJustificacion = new JustificacionEntity();
        crearJustificacion.setRut(rut);
        model.addAttribute("empleadoJustificar",crearJustificacion );
        return "/justificar-empleado";
    }

}
