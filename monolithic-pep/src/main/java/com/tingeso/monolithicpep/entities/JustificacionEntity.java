package com.tingeso.monolithicpep.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "justificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private int id;
    private int rut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;


    public void setNewId(int id){
        this.id = id;
    }

}
