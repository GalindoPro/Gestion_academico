package gestion_academico.sistema_de_gestion.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import gestion_academico.sistema_de_gestion.DTOs.InscripcionDTO;
import gestion_academico.sistema_de_gestion.Entitie.Inscripcion;
import gestion_academico.sistema_de_gestion.Service.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping
    public Inscripcion crear(@RequestBody InscripcionDTO dto) {
        return inscripcionService.crearInscripcion(dto);
    }
}
