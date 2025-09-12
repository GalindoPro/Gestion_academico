package gestion_academico.sistema_de_gestion.Service;

import gestion_academico.sistema_de_gestion.Entitie.Curso;
import gestion_academico.sistema_de_gestion.Entitie.Profesor;
import gestion_academico.sistema_de_gestion.Repository.CursoRepository;
import gestion_academico.sistema_de_gestion.Repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepo;
    private final ProfesorRepository profesorRepo;

    public List<Curso> listarTodos() {
        return cursoRepo.findAll();
    }

    public Curso guardar(Curso curso) {
        return cursoRepo.save(curso);
    }

    public Curso buscarPorId(Long id) {
        return cursoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public void eliminar(Long id) {
        cursoRepo.deleteById(id);
    }

    public Curso actualizar(Long id, Curso nuevo) {
        Curso existente = buscarPorId(id);
        existente.setNombreCurso(nuevo.getNombreCurso());
        existente.setDescripcion(nuevo.getDescripcion());

        // Validar profesor
        Long idProfesor = nuevo.getProfesor().getIdProfesor();
        Profesor profesor = profesorRepo.findById(idProfesor)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        existente.setProfesor(profesor);

        return cursoRepo.save(existente);
    }

    public Curso actualizarParcial(Long id, Map<String, Object> campos) {
        Curso existente = buscarPorId(id);

        if (campos.containsKey("nombreCurso")) {
            existente.setNombreCurso((String) campos.get("nombreCurso"));
        }
        if (campos.containsKey("descripcion")) {
            existente.setDescripcion((String) campos.get("descripcion"));
        }
        if (campos.containsKey("profesor")) {
            Map<String, Object> profesorMap = (Map<String, Object>) campos.get("profesor");
            Long idProfesor = Long.valueOf(profesorMap.get("idProfesor").toString());
            Profesor profesor = profesorRepo.findById(idProfesor)
                    .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
            existente.setProfesor(profesor);
        }

        return cursoRepo.save(existente);
    }
}
