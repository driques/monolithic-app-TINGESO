package com.tingeso.monolithicpep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.Attribute;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    @GetMapping("/upload")
    public String index(){

        return "upload";
    }




    @PostMapping("/upload")
    public String UploadData(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        if(file.isEmpty()){
            System.out.println("Error en la subida de archivos");
            return null;
        }
        String newDir = "/";

        StringBuilder constructor = new StringBuilder();
        constructor.append(newDir);
        constructor.append(file.getOriginalFilename());

        byte[] dataBytes = file.getBytes();

        Path url = Paths.get(constructor.toString());

        Files.write(url,dataBytes);

        attributes.addFlashAttribute("message","Datos cargados con exito.");

        return "redirect:/status";
    }

    @GetMapping("/status")
    public String status(){
        return "status";
    }


}
