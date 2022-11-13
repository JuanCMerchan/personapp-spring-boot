/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.graph.response;

import java.util.List;

import lombok.Data;


@Data
public class PersonaGraph {

    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;
    private List<TelefonoGraph> telefonos;
    private List<EstudiosGraph> estudios;
    
}
