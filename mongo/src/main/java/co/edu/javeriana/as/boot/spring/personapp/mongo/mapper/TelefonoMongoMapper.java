package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Telefono;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.TelefonoMongoEntity;

@Component
public class TelefonoMongoMapper {
    public TelefonoMongoEntity toTelefonoEntityFromTelefono(Telefono telefono, PersonaMongoEntity personaEntity) {
        TelefonoMongoEntity telefonoEntity = new TelefonoMongoEntity();
        telefonoEntity.setNum(telefono.getNum());
        telefonoEntity.setOper(telefono.getOper());
        return telefonoEntity;
    }

    public Telefono toTelefonoFromTelefonoEntity(TelefonoMongoEntity telefonoEntity) {
        Telefono telefono = new Telefono();
        telefono.setNum(telefonoEntity.getNum());
        telefono.setOper(telefonoEntity.getOper());
        return telefono;
    }
    
    public List<TelefonoMongoEntity> toListTelefonoEntityFromListTelefono(List<Telefono> telefonos, PersonaMongoEntity personaEntity) {
        List<TelefonoMongoEntity> telefonoEntities = new ArrayList<>();
        for(Telefono telefono : telefonos) {
            telefonoEntities.add(toTelefonoEntityFromTelefono(telefono, personaEntity));
        }
        return telefonoEntities;
    }

    public List<Telefono> toListTelefonoFromListTelefonoEntity(List<TelefonoMongoEntity> telefonoEntities) {
        List<Telefono> telefonos = new ArrayList<>();
        for(TelefonoMongoEntity telefonoEntity : telefonoEntities) {
            telefonos.add(toTelefonoFromTelefonoEntity(telefonoEntity));
        }
        return telefonos;
    }
}
