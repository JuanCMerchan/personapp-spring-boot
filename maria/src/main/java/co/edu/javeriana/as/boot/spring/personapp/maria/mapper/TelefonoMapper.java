package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Telefono;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.TelefonoEntity;

@Component
public class TelefonoMapper {
    public TelefonoEntity toTelefonoEntityFromTelefono(Telefono telefono, PersonaEntity personaEntity) {
        TelefonoEntity telefonoEntity = new TelefonoEntity();
        telefonoEntity.setNum(telefono.getNum());
        telefonoEntity.setOper(telefono.getOper());
        telefonoEntity.setDuenio(personaEntity);
        return telefonoEntity;
    }

    public Telefono toTelefonoFromTelefonoEntity(TelefonoEntity telefonoEntity) {
        Telefono telefono = new Telefono();
        telefono.setNum(telefonoEntity.getNum());
        telefono.setOper(telefonoEntity.getOper());
        return telefono;
    }
    
    public List<TelefonoEntity> toListTelefonoEntityFromListTelefono(List<Telefono> telefonos, PersonaEntity personaEntity) {
        List<TelefonoEntity> telefonoEntities = new ArrayList<>();
        for(Telefono telefono : telefonos) {
            telefonoEntities.add(toTelefonoEntityFromTelefono(telefono, personaEntity));
        }
        return telefonoEntities;
    }

    public List<Telefono> toListTelefonoFromListTelefonoEntity(List<TelefonoEntity> telefonoEntities) {
        List<Telefono> telefonos = new ArrayList<>();
        for(TelefonoEntity telefonoEntity : telefonoEntities) {
            telefonos.add(toTelefonoFromTelefonoEntity(telefonoEntity));
        }
        return telefonos;
    }
}
