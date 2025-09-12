package gestion_academico.sistema_de_gestion.Service;

import gestion_academico.sistema_de_gestion.Entitie.Estudiante;
import gestion_academico.sistema_de_gestion.Repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepo;

    public List<Estudiante> listarTodos() {
        return estudianteRepo.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    public Estudiante buscarPorId(Long id) {
        return estudianteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public void eliminar(Long id) {
        estudianteRepo.deleteById(id);
    }

    public Estudiante actualizar(Long id, Estudiante nuevo) {
        Estudiante existente = buscarPorId(id);
        existente.setNombre(nuevo.getNombre());
        existente.setApellido(nuevo.getApellido());
        existente.setEmail(nuevo.getEmail());
        existente.setTelefono(nuevo.getTelefono());
        return estudianteRepo.save(existente);
    }

    public Estudiante actualizarParcial(Long id, Map<String, Object> campos) {
        Estudiante existente = buscarPorId(id);

        if (campos.containsKey("nombre")) {
            existente.setNombre((String) campos.get("nombre"));
        }
        if (campos.containsKey("apellido")) {
            existente.setApellido((String) campos.get("apellido"));
        }
        if (campos.containsKey("email")) {
            existente.setEmail((String) campos.get("email"));
        }
        if (campos.containsKey("telefono")) {
            existente.setTelefono((String) campos.get("telefono"));
        }

        return estudianteRepo.save(existente);
    }
}
