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
    public String[] formatToArray(String myData){
        String[] myDataArray = myData.split("\n",-1);
        return myDataArray;
    }
    public String formatToDate(String toFormat){
        //Recibo string de la forma 2022/08/17;08:00;11.234.123-6
        //Debo retornar 2022-08-17
        String[] arrayFormat = toFormat.split(";",-1);
        String strDate = arrayFormat[0];
        String[] getDate = strDate.split("/",-1);
        if (getDate.length==3){
            String returnDate = getDate[0] + "-" + getDate[1] + "-" + getDate[2];
            return returnDate;

        }else{
            return null;
        }
    }

    public String formatToHour(String toFormat){
        //Recibo string de la forma 2022/08/17;08:00;11.234.123-6
        //Debo retornar 08:00
        String[] arrayFormat = toFormat.split(";",-1);
        if(arrayFormat.length>1){
            String strHour = arrayFormat[1];
            return strHour;
        }
        return null;
    }

    public String formatToRut(String toFormat){
        //Recibo string de la forma 2022/08/17;08:00;11.234.123-6
        //Debo retornar 112341236
        String[] arrayFormat = toFormat.split(";",-1);
        if(arrayFormat.length>1){
            String strRut = arrayFormat[2];
            String[] getRut = strRut.split("\\.",-1);
            String concatRut = getRut[0]+getRut[1]+getRut[2];
            String[] getRutSV = concatRut.split("-",-1);
            String finalRut = getRutSV[0]+getRutSV[1];
            return finalRut;
        }
        return null;
    }




}
