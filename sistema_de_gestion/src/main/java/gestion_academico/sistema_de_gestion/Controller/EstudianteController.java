package gestion_academico.sistema_de_gestion.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import gestion_academico.sistema_de_gestion.Entitie.Estudiante;
import gestion_academico.sistema_de_gestion.Service.EstudianteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listarTodos();
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteService.guardar(estudiante);
    }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Long id) {
        return estudianteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        return estudianteService.actualizar(id, estudianteActualizado);
    }

    @PatchMapping("/{id}")
    public Estudiante actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return estudianteService.actualizarParcial(id, campos);
    }
}
