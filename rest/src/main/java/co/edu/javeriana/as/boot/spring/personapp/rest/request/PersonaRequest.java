/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.request;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.rest.response.EstudiosResponse;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.TelefonoResponse;
import lombok.Data;


@Data
public class PersonaRequest {

    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;
    private List<TelefonoResponse> telefono;
    private List<EstudiosResponse> estudios;
    
}
