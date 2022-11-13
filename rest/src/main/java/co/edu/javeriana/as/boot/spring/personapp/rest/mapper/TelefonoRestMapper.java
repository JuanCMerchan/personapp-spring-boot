package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Telefono;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.TelefonoRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.TelefonoResponse;

@Component
public class TelefonoRestMapper {
    public TelefonoResponse fromTelefonoToTelefonoResponse(Telefono telefono) {
        if (telefono == null) {
            return null;
        }
        TelefonoResponse telefonoResponse = new TelefonoResponse();
        telefonoResponse.setNum(telefono.getNum());
        telefonoResponse.setOper(telefono.getOper());
        return telefonoResponse;
    }

    public Telefono fromTelefonoRequestToTelefono(TelefonoRequest telefonoRequest) {
        if (telefonoRequest == null) {
            return null;
        }
        Telefono telefono = new Telefono();
        telefono.setNum(telefonoRequest.getNum());
        telefono.setOper(telefonoRequest.getOper());
        return telefono;
    }

    public List<Telefono> fromListTelefonoRequestToListTelefono(List<TelefonoRequest> telefonoRequests) {
        List<Telefono> telefonos = new ArrayList<>();
        for (TelefonoRequest telefonoRequest : telefonoRequests) {
            telefonos.add(fromTelefonoRequestToTelefono(telefonoRequest));
        }
        return telefonos;
    }

    public List<TelefonoResponse> fromListTelefonoToListTelefonoResponse(List<Telefono> telefonos) {
        List<TelefonoResponse> telefonoResponses = new ArrayList<>();
        for (Telefono telefono : telefonos) {
            telefonoResponses.add(fromTelefonoToTelefonoResponse(telefono));
        }
        return telefonoResponses;
    }
}
