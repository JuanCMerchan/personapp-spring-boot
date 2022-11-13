package co.edu.javeriana.as.boot.spring.personapp.graph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfesionUseCase;
import co.edu.javeriana.as.boot.spring.personapp.graph.mapper.ProfesionGraphMapper;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.ProfesionGraph;


@Controller
public class ProfesionController {
    @Value("${bandera.Db}")
    private int bandera;

    @Autowired
    ProfesionGraphMapper profesionGraphMapper;

    @Autowired
    ProfesionUseCase profesionUseCase;

    @QueryMapping
    public List<ProfesionGraph> profesiones() {
        return profesionGraphMapper.fromListProfesionesToListProfesionesGraph(profesionUseCase.findAll(bandera));
    }

    @MutationMapping
    public Boolean agregarProfesion(@Argument("profesion") ProfesionGraph profesionGraph) {
        return profesionUseCase.agregar(profesionGraphMapper.fromProfesionGraphToProfesion(profesionGraph), bandera);
    }

    @MutationMapping
    public Boolean actualizarProfesion(@Argument("id") Integer id, @Argument("profesion") ProfesionGraph profesionGraph) {
        return profesionUseCase.editar(id, profesionGraphMapper.fromProfesionGraphToProfesion(profesionGraph), bandera);
    }

    @MutationMapping
    public Boolean borrarProfesion(@Argument("id") Integer id) {
        return profesionUseCase.eliminar(id, bandera);
    }
}
