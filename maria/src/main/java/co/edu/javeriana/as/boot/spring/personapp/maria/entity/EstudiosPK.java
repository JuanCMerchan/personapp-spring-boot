package co.edu.javeriana.as.boot.spring.personapp.maria.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 *
 * @author aasanchez
 */
@Data
@Embeddable
public class EstudiosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_prof", nullable = false)
    private int idProf;
    @Basic(optional = false)
    @Column(name = "cc_per", nullable = false)
    private int ccPer;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProf;
        hash += (int) ccPer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstudiosPK)) {
            return false;
        }
        EstudiosPK other = (EstudiosPK) object;
        if (this.idProf != other.idProf) {
            return false;
        }
        if (this.ccPer != other.ccPer) {
            return false;
        }
        return true;
    }
}