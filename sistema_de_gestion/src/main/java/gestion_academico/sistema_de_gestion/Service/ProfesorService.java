package gestion_academico.sistema_de_gestion.Service;

import gestion_academico.sistema_de_gestion.Entitie.Profesor;
import gestion_academico.sistema_de_gestion.Repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepo;

    public List<Profesor> listarTodos() {
        return profesorRepo.findAll();
    }

    public Profesor guardar(Profesor profesor) {
        return profesorRepo.save(profesor);
    }

    public Profesor buscarPorId(Long id) {
        return profesorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    public void eliminar(Long id) {
        profesorRepo.deleteById(id);
    }

    public Profesor actualizar(Long id, Profesor nuevo) {
        Profesor existente = buscarPorId(id);
        existente.setNombre(nuevo.getNombre());
        existente.setApellido(nuevo.getApellido());
        existente.setEmail(nuevo.getEmail());
        existente.setTelefono(nuevo.getTelefono());
        return profesorRepo.save(existente);
    }

    public Profesor actualizarParcial(Long id, Map<String, Object> campos) {
        Profesor existente = buscarPorId(id);

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

        return profesorRepo.save(existente);
    }
}
