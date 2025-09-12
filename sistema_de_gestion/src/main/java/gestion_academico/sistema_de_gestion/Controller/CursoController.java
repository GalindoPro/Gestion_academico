package gestion_academico.sistema_de_gestion.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import gestion_academico.sistema_de_gestion.Entitie.Curso;
import gestion_academico.sistema_de_gestion.Service.CursoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listarTodos();
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.guardar(curso);
    }

    @GetMapping("/{id}")
    public Curso obtener(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        return cursoService.actualizar(id, cursoActualizado);
    }

    @PatchMapping("/{id}")
    public Curso actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return cursoService.actualizarParcial(id, campos);
    }
}
