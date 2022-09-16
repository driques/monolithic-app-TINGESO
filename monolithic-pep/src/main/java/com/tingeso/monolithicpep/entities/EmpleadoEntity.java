package com.tingeso.monolithicpep.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public int rut;
    public String apellidos;
    public String nombres;
    public String fecha_nacimiento;
    public String id_categoria;
    public String ingreso_empresa;

}
