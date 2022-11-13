package co.edu.javeriana.as.boot.spring.personapp.graph.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Telefono;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.TelefonoGraph;

@Component
public class TelefonoGraphMapper {
    public TelefonoGraph fromTelefonoToTelefonoGraph(Telefono telefono) {
        if (telefono == null) {
            return null;
        }
        TelefonoGraph telefonoGraph = new TelefonoGraph();
        telefonoGraph.setNum(telefono.getNum());
        telefonoGraph.setOper(telefono.getOper());
        return telefonoGraph;
    }

    public Telefono fromTelefonoGraphToTelefono(TelefonoGraph telefonoGraph) {
        if (telefonoGraph == null) {
            return null;
        }
        Telefono telefono = new Telefono();
        telefono.setNum(telefonoGraph.getNum());
        telefono.setOper(telefonoGraph.getOper());
        return telefono;
    }

    public List<Telefono> fromListTelefonoGraphToListTelefono(List<TelefonoGraph> telefonoGraphs) {
        List<Telefono> telefonos = new ArrayList<>();
        for (TelefonoGraph telefonoGraph : telefonoGraphs) {
            telefonos.add(fromTelefonoGraphToTelefono(telefonoGraph));
        }
        return telefonos;
    }

    public List<TelefonoGraph> fromListTelefonoToListTelefonoGraph(List<Telefono> telefonos) {
        List<TelefonoGraph> telefonoGraphs = new ArrayList<>();
        for (Telefono telefono : telefonos) {
            telefonoGraphs.add(fromTelefonoToTelefonoGraph(telefono));
        }
        return telefonoGraphs;
    }
}
