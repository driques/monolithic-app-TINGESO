package com.tingeso.monolithicpep.services;

import com.tingeso.monolithicpep.controllers.FileController;
import com.tingeso.monolithicpep.entities.EmpleadoEntity;
import com.tingeso.monolithicpep.entities.PlanillaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class OficinaRRHHService {
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    HorasExtraService horasExtraService;
    @Autowired
    JustificacionService justificacionService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    PlanillaService planillaService;


    //Porcentajes de cotizaciones.
    int cotizacionSalud = 8;
    int cotizacionPrevisional = 10;

    public int aniosEmpresa(int rut){
        LocalDate empleadoIngreso = empleadoService.getAnioIngreso(rut);
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(empleadoIngreso,hoy);
        return period.getYears();

    }
    //Se obtiene el anio de ingreso, el anio actual y se retorna el porcentaje de bonificacion.
    public int calculoBonificaciones(int rut){
        LocalDate empleadoIngreso = empleadoService.getAnioIngreso(rut);
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(empleadoIngreso,hoy);
        if(period.getYears()<5){
            return 0;
        } else if (period.getYears()>=5) {
            return 5;

        } else if (period.getYears()>=10) {
            return 8;

        } else if (period.getYears()>=15) {
            return 11;
            
        } else if (period.getYears()>=20) {
            return 14;
            
        } else if (period.getYears()>=25) {
            return 17;
        }
        else{
            return -1;
        }
    }
    public String readData(){
        FileController getData = new FileController();
        System.out.println("Path actualizado...");
        String myData = getData.readTxt("/DATA.txt");
        return myData;
    }
    boolean myContains(String[] array, String string){
        for(String i:array){
            if(i.equals(string)){
                return true;
            }
        }
        return false;
    }
    public int calculoHorasExtra(int rut){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        int horasExtra = 0;
        int horaSalida = 18;
        FileController fileController = new FileController();
        String myData = readData();
        if(myData.isEmpty()) return -1;
        String[] getDataArray = fileController.formatToArray(myData);
        fileController.formatToArray(myData);
        for(String a: getDataArray){
            if(a.isEmpty()!=true){
                if(Integer.parseInt(fileController.formatToRut(a))==rut){
                    String date = fileController.formatToDate(a);
                    String[] datesByRut = horasExtraService.getDatesByRut(rut);
                    String hour = fileController.formatToHour(a);
                    String[] arrayFormat = hour.split(":",-1);
                    int totalHour = Integer.parseInt(arrayFormat[0]);
                    if(totalHour>horaSalida && myContains(datesByRut,date)){
                        horasExtra = horasExtra + (totalHour-horaSalida);
                    }
                }
            }
        }
        //Se hace el calculo de las horas extra.
        String categoriaEmpleado = empleado.getCategoria();
        char charCategoria = categoriaEmpleado.charAt(0);

        return montoHoraExtra(charCategoria,horasExtra);

    }
    public int montoHoraExtra(char charCategoria, int horasExtra){
        if(charCategoria=='a'){
            int montoHorasExtra = 25000;
            return montoHorasExtra*horasExtra;
        }
        else if(charCategoria=='b'){
            int montoHorasExtra = 20000;
            return montoHorasExtra*horasExtra;
        } else if (charCategoria=='c') {
            int montoHorasExtra = 10000;
            return montoHorasExtra*horasExtra;
        }
        //En caso de que no exista la categoria, se retorna 0.
        return  0;
    }
    public int sueldoFijo(char charCategoria){
        if(charCategoria=='a'){
            int montoHorasExtra = 25000;
            return montoHorasExtra;
        }
        else if(charCategoria=='b'){
            int montoHorasExtra = 20000;
            return montoHorasExtra;
        } else if (charCategoria=='c') {
            int montoHorasExtra = 10000;
            return montoHorasExtra;
        }
        //En caso de que no exista la categoria, se retorna 0.
        return  0;


    }
    public int calculoDescuentos(int rut){
        int porcentajeDescuento = 0;
        FileController fileController = new FileController();
        String myData = readData();
        String[] getDataArray = fileController.formatToArray(myData);
        fileController.formatToArray(myData);
        for(String a: getDataArray){
            if(a.isEmpty()!=true){
                if(Integer.parseInt(fileController.formatToRut(a))==rut){
                    String date = fileController.formatToDate(a);
                    String[] datesByRut = justificacionService.getDatesByRut(rut);
                    String hour = fileController.formatToHour(a);
                    String[] arrayFormat = hour.split(":",-1);
                    int hora = Integer.valueOf(arrayFormat[0]);
                    int minutos = Integer.valueOf(arrayFormat[1]);
                    if((hora>=8 && minutos>=10) || (hora==9 && minutos<=10)){
                        if (hora==8 && minutos>=10 && minutos<25) porcentajeDescuento = porcentajeDescuento + 1;
                        if (hora==8 && minutos>=25 && minutos<45) porcentajeDescuento = porcentajeDescuento + 3;
                        if ((hora==8 && minutos>=45 && minutos<60)||(hora==9 && minutos<=10)) porcentajeDescuento = porcentajeDescuento + 6;
                    } else if (hora>=9 && minutos>10){
                        if(myContains(datesByRut,date)) porcentajeDescuento = porcentajeDescuento;
                        else porcentajeDescuento=porcentajeDescuento+15;
                    }
                }
            }
        }
        return porcentajeDescuento;
    }

    public int calculoSueldoFinal(int rut){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        String categoria = empleado.getCategoria();
        int sueldo = categoriaService.getSueldoById(categoria);
        int porcentajeBonificacion = (calculoBonificaciones(rut)*sueldo)/100;
        int montoHoraExtra = calculoHorasExtra(rut);
        int sueldoBruto = sueldo+porcentajeBonificacion+montoHoraExtra;
        sueldoBruto = sueldoBruto - montoDescuento(rut,sueldoBruto);
        int sueldoLiquido = sueldoBruto - (getCotizacionPrevisional(sueldoBruto)+getCotizacionSalud(sueldoBruto));
        return sueldoLiquido;
    }

    public int bonificacion(int rut, int sueldo){
        return (calculoBonificaciones(rut)*sueldo)/100;
    }

    public int montoDescuento(int rut ,int sueldoBruto){
        int porcentajeDescuentos = calculoDescuentos(rut);
        int descuento = ((sueldoBruto * porcentajeDescuentos)/100);
        return descuento;

    }

    public int brutoSinCotizacion(int sueldoBruto, int montoDescuento){
        return sueldoBruto-montoDescuento;
    }

    public int getCotizacionPrevisional(int sueldoBruto){
        return (sueldoBruto*cotizacionPrevisional)/100;
    }
    public int getCotizacionSalud(int sueldoBruto){
       return (sueldoBruto * cotizacionSalud)/100;
    }


    public void creaPlanilla(){
        planillaService.dropTable();
        ArrayList<EmpleadoEntity> empleados=empleadoService.obtenerEmpleados();
        for(EmpleadoEntity a : empleados){
            PlanillaEntity planilla = new PlanillaEntity();
            planilla.setRut(a.getRut());
            planilla.setAnios_servicio(aniosEmpresa(a.getRut()));
            planilla.setNombre_empleado(a.getNombres()+" "+a.getApellidos());
            planilla.setSueldo_fijo(categoriaService.getSueldoById(a.getCategoria()));
            planilla.setBonificacion(bonificacion(a.getRut(), categoriaService.getSueldoById(a.getId_categoria())));
            planilla.setHoras_extra_monto(calculoHorasExtra(a.getRut()));
            int sueldoBruto = categoriaService.getSueldoById(a.getCategoria())+bonificacion(a.getRut(), categoriaService.getSueldoById(a.getId_categoria()))+calculoHorasExtra(a.getRut());

            planilla.setMonto_descuento(montoDescuento(a.getRut(),sueldoBruto));

            planilla.setBruto(brutoSinCotizacion(sueldoBruto,montoDescuento(a.getRut(),sueldoBruto)));

            planilla.setCotizacion_previsional(getCotizacionPrevisional(brutoSinCotizacion(sueldoBruto,montoDescuento(a.getRut(),sueldoBruto))));

            planilla.setCotizacion_salud(getCotizacionSalud(brutoSinCotizacion(sueldoBruto,montoDescuento(a.getRut(),sueldoBruto))));

            planilla.setSueldo_final(calculoSueldoFinal(a.getRut()));
            planillaService.guardarPlanilla(planilla);
        }


    }

}
