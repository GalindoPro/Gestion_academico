package gestion_academico.sistema_de_gestion.Service;

import gestion_academico.sistema_de_gestion.DTOs.InscripcionDTO;
import gestion_academico.sistema_de_gestion.Entitie.*;
import gestion_academico.sistema_de_gestion.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final InscripcionRepository inscripcionRepo;
    private final EstudianteRepository estudianteRepo;
    private final CursoRepository cursoRepo;

    // Crear inscripción
    public Inscripcion crearInscripcion(InscripcionDTO dto) {
        Estudiante estudiante = estudianteRepo.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Curso curso = cursoRepo.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(dto.getFechaInscripcion());

        return inscripcionRepo.save(inscripcion);
    }

    // Listar todas las inscripciones
    public List<Inscripcion> listarTodas() {
        return inscripcionRepo.findAll();
    }

    // Buscar inscripción por ID
    public Inscripcion buscarPorId(Long id) {
        return inscripcionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
    }

    // Listar inscripciones por estudiante
    public List<Inscripcion> listarPorEstudiante(Long idEstudiante) {
        return inscripcionRepo.findByEstudiante_IdEstudiante(idEstudiante);
    }

    // Listar inscripciones por curso
    public List<Inscripcion> listarPorCurso(Long idCurso) {
        return inscripcionRepo.findByCurso_IdCurso(idCurso);
    }

    // Listar inscripciones por fecha exacta
    public List<Inscripcion> listarPorFecha(LocalDate fecha) {
        return inscripcionRepo.findByFechaInscripcion(fecha);
    }

    // Listar inscripciones entre dos fechas
    public List<Inscripcion> listarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return inscripcionRepo.findByFechaInscripcionBetween(inicio, fin);
    }

    // Eliminar inscripción
    public void eliminar(Long id) {
        inscripcionRepo.deleteById(id);
    }

    // Actualización completa
    public Inscripcion actualizar(Long id, InscripcionDTO dto) {
        Inscripcion existente = buscarPorId(id);

        Estudiante estudiante = estudianteRepo.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Curso curso = cursoRepo.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        existente.setEstudiante(estudiante);
        existente.setCurso(curso);
        existente.setFechaInscripcion(dto.getFechaInscripcion());

        return inscripcionRepo.save(existente);
    }

    // Actualización parcial
    public Inscripcion actualizarParcial(Long id, Map<String, Object> campos) {
        Inscripcion existente = buscarPorId(id);

        if (campos.containsKey("idEstudiante")) {
            Long idEstudiante = Long.valueOf(campos.get("idEstudiante").toString());
            Estudiante estudiante = estudianteRepo.findById(idEstudiante)
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
            existente.setEstudiante(estudiante);
        }

        if (campos.containsKey("idCurso")) {
            Long idCurso = Long.valueOf(campos.get("idCurso").toString());
            Curso curso = cursoRepo.findById(idCurso)
                    .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
            existente.setCurso(curso);
        }

        if (campos.containsKey("fechaInscripcion")) {
            LocalDate fecha = LocalDate.parse(campos.get("fechaInscripcion").toString());
            existente.setFechaInscripcion(fecha);
        }

        return inscripcionRepo.save(existente);
    }
}
