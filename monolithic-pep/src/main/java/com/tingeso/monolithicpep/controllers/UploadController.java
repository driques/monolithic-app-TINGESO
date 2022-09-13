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
    @GetMapping("/")
    public String index(){

        return "upload";
    }
    @GetMapping("/test-file")
    public String testFile(){
        FileController getData = new FileController();
        String myData = getData.readTxt("/Users/driques/Documents/2-2022/Tingeso/PEP 1 TINGESO/monolithic-app-TINGESO/monolithic-pep/src/main/resources/data_file/DATA.txt");
        System.out.println(myData);
        return "test";
    }
    @PostMapping("/upload")
    public String UploadData(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        if(file.isEmpty()){
            System.out.println("Error en la subida de archivos");
            return null;
        }
        String newDir = createPath();
        StringBuilder constructor = new StringBuilder();
        constructor.append(newDir);
        constructor.append(File.separator);
        constructor.append("data_file");
        constructor.append(File.separator);
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

    public String createPath(){
        String directoryName = "src/main/resources/data_file";
        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }
        String newPath = directory.getAbsolutePath();
        newPath = newPath.replace("/data_file","");
        return newPath;

    }


}
