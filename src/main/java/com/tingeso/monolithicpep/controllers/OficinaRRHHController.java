package com.tingeso.monolithicpep.controllers;

import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.entities.PlanillaEntity;
import com.tingeso.monolithicpep.services.OficinaRRHHService;
import com.tingeso.monolithicpep.services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class OficinaRRHHController {
    @Autowired
    OficinaRRHHService oficinaRRHHService;
    @Autowired
    PlanillaService planillaService;

    @GetMapping("/calculo")
    public String crearPlanilla(Model model){
        oficinaRRHHService.creaPlanilla();
        ArrayList<PlanillaEntity> empleadosPlanilla=planillaService.obtenerEmpleados();
        model.addAttribute("empleadosPlanilla",empleadosPlanilla);
        return "planilla";
    }
    @GetMapping("/delete-datafile")
    public String deleteDataFile(){
        oficinaRRHHService.removePath();
        return "index";

    }

}
