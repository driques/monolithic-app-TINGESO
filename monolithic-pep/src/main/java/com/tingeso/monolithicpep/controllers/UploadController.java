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
//https://www.youtube.com/watch?v=BmL_THqZLEA
@Controller
public class UploadController {
    @GetMapping("/")
    public String index(){

        return null;
    }
    @PostMapping("/upload")
    public String UploadData(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        if(file.isEmpty()){
            System.out.println("Error en la subida de archivos");
            return null;
        }
        createPath();
        StringBuilder constructor = new StringBuilder();
        constructor.append(System.getProperty("user.home"));
        constructor.append(File.separator);
        constructor.append("data_file");
        constructor.append(File.separator);
        constructor.append(file.getOriginalFilename());

        byte[] dataBytes = file.getBytes();

        Path url = Paths.get(constructor.toString());

        Files.write(url,dataBytes);

        attributes.addFlashAttribute("message","Datos cargados con exito.");

        return null;
    }


    public void createPath(){
        String directoryName = System.getProperty("home")+"/data_file";
        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }

        File file = new File(directoryName );

    }


}
