package co.edu.javeriana.as.boot.spring.personapp.graph.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.ProfesionGraph;

@Component
public class ProfesionGraphMapper {

    public List<ProfesionGraph> fromListProfesionesToListProfesionesGraph(List<Profesion> profesiones) {
        List<ProfesionGraph> personaGraph = new ArrayList<ProfesionGraph>();
        for( Profesion profesion : profesiones){
            personaGraph.add(fromProfesionToProfesionGraph(profesion));
        }
        return personaGraph;
    }

    public Profesion fromProfesionGraphToProfesion(ProfesionGraph profesionGraph) {
        if (profesionGraph == null) {
            return null;
        }
        Profesion profesion = new Profesion();
        profesion.setId(profesionGraph.getId());
        profesion.setNom(profesionGraph.getNom());
        profesion.setDes(profesionGraph.getDes());
        return profesion;
    }

    public ProfesionGraph fromProfesionToProfesionGraph(Profesion profesion) {
        if (profesion == null) {
            return null;
        }
        ProfesionGraph profesionGraph = new ProfesionGraph();
        profesionGraph.setId(profesion.getId());
        profesionGraph.setNom(profesion.getNom());
        profesionGraph.setDes(profesion.getDes());
        return profesionGraph;
    }
    
}
