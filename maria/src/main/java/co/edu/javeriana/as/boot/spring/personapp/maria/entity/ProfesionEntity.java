package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Data;


@Entity
@Table(catalog = "persona_db", schema = "", name = "profesion")
@NamedQueries({
    @NamedQuery(name = "ProfesionEntity.findAll", query = "SELECT p FROM ProfesionEntity p")
    , @NamedQuery(name = "ProfesionEntity.findById", query = "SELECT p FROM ProfesionEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ProfesionEntity.findByNom", query = "SELECT p FROM ProfesionEntity p WHERE p.nom = :nom")})
@Data
public class ProfesionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 90)
    private String nom;
    @Lob
    @Column(length = 65535)
    private String des;
}
