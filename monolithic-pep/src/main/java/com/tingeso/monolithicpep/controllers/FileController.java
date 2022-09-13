package com.tingeso.monolithicpep.controllers;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.FileReader;

@Controller
public class FileController {
    public String readTxt(String path){
        String content="";
        try{
            String tmp = "";
            String bufferRead;
            FileReader getPath = new FileReader(path);
            BufferedReader buffer = new BufferedReader(getPath);
            while (null != (bufferRead = buffer.readLine())){
                tmp = tmp+"\n"+bufferRead;
            }
            content =  tmp;


        }
        catch (Exception e){
            System.out.println("Archivo inexistente...");
        }
        return content;
    }
}
