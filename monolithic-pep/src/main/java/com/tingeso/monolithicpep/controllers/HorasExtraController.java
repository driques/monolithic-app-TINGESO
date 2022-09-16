package com.tingeso.monolithicpep.controllers;


import org.springframework.stereotype.Controller;

@Controller
public class HorasExtraController {
    public String testFile(){
        FileController getData = new FileController();
        String myData = getData.readTxt("/Users/driques/Documents/2-2022/Tingeso/PEP 1 TINGESO/monolithic-app-TINGESO/monolithic-pep/src/main/resources/data_file/DATA.txt");
        String[] arrayData = getData.formatToArray(myData);
        for(String a: arrayData){
            System.out.println(getData.formatToDate(a));
            System.out.println("---------------");
            System.out.println(getData.formatToHour(a));
            System.out.println("---------------");
            System.out.println(getData.formatToRut(a));
            System.out.println("==============");
        }

        return "test";
    }
    public String[] calculoHorasExtra(){

        return null;


    }
}
