package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfesionUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.ProfesionController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.ProfesionRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfesionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfesionResponse;

@RestController
@RequestMapping("/profesion")
public class ProfesionControllerImpl implements ProfesionController {

    @Value("${bandera.Db}")
    private int bandera;

    @Autowired
    private ProfesionUseCase profesionAppAdapter;

    @Autowired
    private ProfesionRestMapper profesionRestMapper;

    @Override
    @GetMapping
    public List<ProfesionResponse> buscar() {
        List<Profesion> profesiones = profesionAppAdapter.findAll(0);
        return profesionRestMapper.fromListProfesionesToListProfesionesResponse(profesiones);
    }

    @Override
    @PostMapping
    public Boolean agregar(@RequestBody ProfesionRequest profesionPostRequest) {
        Profesion p = profesionRestMapper.fromProfesionRequestToProfesion(profesionPostRequest);
        Boolean salida = profesionAppAdapter.agregar(p, bandera);
        return salida;
    }

    @Override
    @PutMapping("/{id}")
    public Boolean actualizar(@PathVariable("id") Integer id, @RequestBody ProfesionRequest profesionPostRequest) {
        Profesion p = profesionRestMapper.fromProfesionRequestToProfesion(profesionPostRequest);
        Boolean salida = profesionAppAdapter.editar(id, p, bandera);
        return salida;
    }

    @Override
    @DeleteMapping("/{id}")
    public Boolean eliminar(@PathVariable("id") Integer cc) {
        Boolean salida = profesionAppAdapter.eliminar(cc, bandera);
        return salida;
    }

    @Override
    @GetMapping("/{id}")
    public ProfesionResponse consultar(@PathVariable("id") Integer id) {
        Profesion profesion = profesionAppAdapter.consultar(id, bandera);
        ProfesionResponse profesionResponse = profesionRestMapper.fromProfesionToProfesionResponse(profesion);
        return profesionResponse;
    }
    
}
