package gestion_academico.sistema_de_gestion.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import gestion_academico.sistema_de_gestion.DTOs.InscripcionDTO;
import gestion_academico.sistema_de_gestion.Entitie.Inscripcion;
import gestion_academico.sistema_de_gestion.Service.InscripcionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping
    public Inscripcion crear(@RequestBody InscripcionDTO dto) {
        return inscripcionService.crearInscripcion(dto);
    }

    @GetMapping
    public List<Inscripcion> listarTodas() {
        return inscripcionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Inscripcion obtenerPorId(@PathVariable Long id) {
        return inscripcionService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<Inscripcion> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return inscripcionService.listarPorEstudiante(idEstudiante);
    }

    @GetMapping("/curso/{idCurso}")
    public List<Inscripcion> listarPorCurso(@PathVariable Long idCurso) {
        return inscripcionService.listarPorCurso(idCurso);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Inscripcion> listarPorFecha(@PathVariable LocalDate fecha) {
        return inscripcionService.listarPorFecha(fecha);
    }

    @GetMapping("/rango")
    public List<Inscripcion> listarPorRangoFechas(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) {
        return inscripcionService.listarPorRangoFechas(inicio, fin);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Inscripcion actualizar(@PathVariable Long id, @RequestBody InscripcionDTO dto) {
        return inscripcionService.actualizar(id, dto);
    }

    @PatchMapping("/{id}")
    public Inscripcion actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return inscripcionService.actualizarParcial(id, campos);
    }
}
