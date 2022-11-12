/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import java.util.List;

import lombok.Data;

/**
 *
 * @author aasanchez
 */
@Data
public class Persona {
    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;
    private List<Telefono> telefonos;
    private List<Estudios> estudios;
}
