package co.edu.javeriana.as.boot.spring.personapp.graph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonaUseCase;
import co.edu.javeriana.as.boot.spring.personapp.graph.mapper.PersonaGraphMapper;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.PersonaGraph;

@Controller
public class PersonaController {
    @Value("${bandera.Db}")
    private int bandera;

    @Autowired
    PersonaUseCase personaUseCase;

    @Autowired
    PersonaGraphMapper personaGraphMapper;

    @QueryMapping
    public List<PersonaGraph> personas() {
        return personaGraphMapper.fromListPersonaToListPersonaGraph(personaUseCase.findAll(bandera));
    }

    @QueryMapping
    public PersonaGraph personaCc(@Argument("cc") Integer cc) {
        return personaGraphMapper.fromPersonaToPersonaGraph(personaUseCase.consultar(cc, bandera));
    }

    @MutationMapping
    public Boolean agregarPersona(@Argument("persona") PersonaGraph personaGraph) {
        return personaUseCase.agregar(personaGraphMapper.fromPersonaGraphToPersona(personaGraph), bandera);
    }

    @MutationMapping
    public Boolean actualizarPersona(@Argument("cc") Integer cc, @Argument("persona") PersonaGraph personaGraph) {
        return personaUseCase.editar(cc, personaGraphMapper.fromPersonaGraphToPersona(personaGraph), bandera);
    }

    @MutationMapping
    public Boolean borrarPersona(@Argument("cc") Integer cc) {
        return personaUseCase.eliminar(cc, bandera);
    }
}
