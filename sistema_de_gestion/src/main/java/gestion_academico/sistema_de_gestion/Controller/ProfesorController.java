package gestion_academico.sistema_de_gestion.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import gestion_academico.sistema_de_gestion.Entitie.Profesor;
import gestion_academico.sistema_de_gestion.Service.ProfesorService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @GetMapping
    public List<Profesor> listar() {
        return profesorService.listarTodos();
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return profesorService.guardar(profesor);
    }

    @GetMapping("/{id}")
    public Profesor obtener(@PathVariable Long id) {
        return profesorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Long id, @RequestBody Profesor profesorActualizado) {
        return profesorService.actualizar(id, profesorActualizado);
    }

    @PatchMapping("/{id}")
    public Profesor actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return profesorService.actualizarParcial(id, campos);
    }
}
