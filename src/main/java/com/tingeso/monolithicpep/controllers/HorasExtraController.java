package com.tingeso.monolithicpep.controllers;


import com.tingeso.monolithicpep.entities.HorasExtraEntity;
import com.tingeso.monolithicpep.services.HorasExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HorasExtraController {
    @Autowired
    HorasExtraService horasExtraService;
    @PostMapping("/horaextra/{id}")
    public String crearHoraExtra(@ModelAttribute HorasExtraEntity horasExtra){
        int myNewId = horasExtraService.findMaxId();
        horasExtra.setId(myNewId);
        System.out.println("testPost..."+horasExtra);

        horasExtraService.guardarHoraExtra(horasExtra);

        System.out.println("testPost..."+horasExtra);
        System.out.println("Hora Extra guardada...");
        return "index";


    }
    @GetMapping(value = "/horaextra/{rut}")
    public String formsHoraExtra(@PathVariable int rut, Model model){
        System.out.println(rut+"<- rut");
        HorasExtraEntity crearHoraExtra = new HorasExtraEntity();
        crearHoraExtra.setRut(rut);
        model.addAttribute("horaExtra",crearHoraExtra );
        return "horaextra";
    }
}
