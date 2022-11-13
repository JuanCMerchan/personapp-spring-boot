package co.edu.javeriana.as.boot.spring.personapp.graph.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Estudios;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.EstudiosGraph;

@Component
public class EstudiosGraphMapper {

    @Autowired
    ProfesionGraphMapper profesionRestMapper;

    public Estudios fromEstudiosGraphToEstudios(EstudiosGraph estudiosRequest) {
        if (estudiosRequest == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Estudios estudios = new Estudios();
        estudios.setFecha(LocalDate.parse(estudiosRequest.getFecha(), formatter));
        estudios.setUniver(estudiosRequest.getUniver());
        estudios.setProfesion(profesionRestMapper.fromProfesionGraphToProfesion(estudiosRequest.getProfesion()));
        return estudios;
    }

    public EstudiosGraph fromEstudiosToEstudiosGraph(Estudios estudios) {
        if (estudios == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        EstudiosGraph estudiosGraph = new EstudiosGraph();
        estudiosGraph.setFecha(estudios.getFecha().format(formatter));
        estudiosGraph.setUniver(estudios.getUniver());
        estudiosGraph.setProfesion(profesionRestMapper.fromProfesionToProfesionGraph(estudios.getProfesion()));
        return estudiosGraph;
    }

    public List<Estudios> fromListEstudiosGraphToListEstudios(List<EstudiosGraph> estudiosGraphs) {
        List<Estudios> estudios = new ArrayList<>();
        for (EstudiosGraph estudiosGraph : estudiosGraphs) {
            estudios.add(fromEstudiosGraphToEstudios(estudiosGraph));
        }
        return estudios;
    }

    public List<EstudiosGraph> fromListEstudiosToListEstudiosGraph(List<Estudios> estudioss) {
        List<EstudiosGraph> estudiosGraphs = new ArrayList<>();
        for (Estudios estudios : estudioss) {
            estudiosGraphs.add(fromEstudiosToEstudiosGraph(estudios));
        }
        return estudiosGraphs;
    }
}
