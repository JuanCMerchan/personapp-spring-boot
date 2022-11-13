/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 *
 * @author aasanchez
 */

@Entity
@Table(name = "persona",catalog = "persona_db",schema = "")
@NamedQueries({
    @NamedQuery(name = "PersonaEntity.findAll", query = "SELECT p FROM PersonaEntity p")
    , @NamedQuery(name = "PersonaEntity.findByCc", query = "SELECT p FROM PersonaEntity p WHERE p.cc = :cc")
    , @NamedQuery(name = "PersonaEntity.findByNombre", query = "SELECT p FROM PersonaEntity p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PersonaEntity.findByApellido", query = "SELECT p FROM PersonaEntity p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "PersonaEntity.findByGenero", query = "SELECT p FROM PersonaEntity p WHERE p.genero = :genero")
    , @NamedQuery(name = "PersonaEntity.findByEdad", query = "SELECT p FROM PersonaEntity p WHERE p.edad = :edad")})
@Data
public class PersonaEntity implements Serializable{
    @Id
    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TelefonoEntity> telefonos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EstudiosEntity> estudios;

}
